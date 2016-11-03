package com.weebly.gaborcsikos.tdd_java8_jbehave.integration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper.AppleBuilder;
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

	@Test
	public void appleCRUD() {
		List<Apple> applesInBeginning = controller.list();
		Assert.assertEquals(AppleFactory.getApples(), applesInBeginning);

		Apple appleToAdd = new AppleBuilder().withColor(Color.GREEN).withType(Type.GRANNYSMITH).build();
		controller.add(appleToAdd);

		Apple result = controller.getAppleById(appleToAdd.getID());
		assertThat(result, is(equalTo(appleToAdd)));

		controller.deleteById(appleToAdd.getID());
		Assert.assertNull(controller.getAppleById(appleToAdd.getID()));

	}

	// TODO Test here predicates

	// TODO test here streams

	// TODO Java 8 Date

	// TODO JBehave
}
