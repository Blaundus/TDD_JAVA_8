/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.jbheave;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.junit.Assert;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
public class JBehaveSteps {

	private static final int GREEN_APPLE_COUNT = 33;
	private static final int YELLOW_APPLE_COUNT = 33;
	private static final int REDCHIEF_COUNT = 20;
	private static final int JONATHAN_COUNT = 14;
	private List<Apple> apples = new ArrayList<Apple>();

	@Given("The initial 100 apples")
	public void init() {
		addRedApples();
		addYellowApples();
		addGreenApples();
	}

	@Then("Then I get 0 apples")
	public void noApplesFound() {
		Assert.assertTrue(apples.isEmpty());
	}

	private void addGreenApples() {
		for (int i = 0; i < GREEN_APPLE_COUNT; i++) {
			Apple apple = new Apple();
			apple.setType(Type.GRANNYSMITH);
			apple.setColor(Color.GREEN);
			apples.add(apple);
		}

	}

	private void addYellowApples() {
		for (int i = 0; i < YELLOW_APPLE_COUNT; i++) {
			Apple apple = new Apple();
			apple.setType(Type.IDARED);
			apple.setColor(Color.YELLOW);
			apples.add(apple);
		}
	}

	private void addRedApples() {
		for (int i = 0; i < REDCHIEF_COUNT; i++) {
			Apple apple = new Apple();
			apple.setType(Type.REDCHIEF);
			apple.setColor(Color.RED);
			apples.add(apple);
		}
		for (int i = 0; i < JONATHAN_COUNT; i++) {
			Apple apple = new Apple();
			apple.setType(Type.JONATHAN);
			apple.setColor(Color.RED);
			apples.add(apple);
		}
	}
}
