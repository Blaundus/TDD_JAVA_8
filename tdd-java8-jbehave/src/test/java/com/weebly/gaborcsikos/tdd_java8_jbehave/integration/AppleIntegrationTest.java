package com.weebly.gaborcsikos.tdd_java8_jbehave.integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper.AppleFactory;

/**
 * 
 * @author Gábor Csikós
 *
 */
public class AppleIntegrationTest {

	public AppleController controller = new AppleController();

	@Test
	public void testInit() {
		controller = new AppleController();
		List<Apple> applesInBeginning = controller.list();
		Assert.assertEquals(AppleFactory.getApples(), applesInBeginning);
	}
	// TODO CRUD and matchers

	// TODO Test here predicates

	// TODO test here streams

	// TODO Java 8 Date

	// TODO JBehave
}
