package com.weebly.gaborcsikos.tdd_java8_jbehave.integration;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;
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
		List<Apple> applesInBeginning = controller.list();
		Assert.assertEquals(AppleFactory.getApples(), applesInBeginning);
	}

	public void addApple() {
		List<Apple> applesInBeginning = controller.list();
		Assert.assertEquals(AppleFactory.getApples(), applesInBeginning);

		Apple appleToAdd = new Apple();
		appleToAdd.setColor(Color.GREEN);
		appleToAdd.setType(Type.GRANNYSMITH);

		controller.add(appleToAdd);

		// Apple result = controller.getAppleById(appleToAdd.getID());
		// TODO continue
	}

	// TODO CRUD

	// TODO CRUD and matchers

	// TODO Test here predicates

	// TODO test here streams

	// TODO Java 8 Date

	// TODO JBehave
}
