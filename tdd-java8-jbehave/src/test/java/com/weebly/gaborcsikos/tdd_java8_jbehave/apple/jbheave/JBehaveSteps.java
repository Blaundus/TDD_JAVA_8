/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.jbheave;

import java.util.ArrayList;
import java.util.List;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
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
	private long counted = 0;

	@Given("The initial 100 apples")
	public void init() {
		apples.clear();
		addRedApples();
		addYellowApples();
		addGreenApples();
	}

	@When("I count the $colorString Apples")
	public void countByColor(String colorString) {
		Color color = getColortype(colorString.toUpperCase());
		counted = apples.stream().filter(p -> color == p.getColor()).count();
	}

	@When("I count the $typeString types")
	public void countByType(String typeString) {
		Type type = getType(typeString.toUpperCase());
		counted = apples.stream().filter(p -> type == p.getType()).count();
	}

	@Then("I get $counted apples")
	public void noApplesFound(long countedParam) {
		Assert.assertEquals("counted apples differ", countedParam, counted);
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

	private Color getColortype(String colorString) {
		Color result = null;
		if ("GREEN".equals(colorString)) {
			result = Color.GREEN;
		} else if ("RED".equals(colorString)) {
			result = Color.RED;
		} else if ("YELLOW".equals(colorString)) {
			result = Color.YELLOW;
		}
		return result;
	}

	private Type getType(String typeString) {
		Type result = null;
		if ("IDARED".equals(typeString)) {
			result = Type.IDARED;
		} else if ("REDCHIEF".equals(typeString)) {
			result = Type.REDCHIEF;
		} else if ("GRANNYSMITH".equals(typeString)) {
			result = Type.GRANNYSMITH;
		} else if ("JONATHAN".equals(typeString)) {
			result = Type.JONATHAN;
		}
		return result;
	}
}
