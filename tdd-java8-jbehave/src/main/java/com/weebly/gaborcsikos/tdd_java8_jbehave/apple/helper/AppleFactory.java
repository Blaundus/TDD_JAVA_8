/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper;

import java.util.ArrayList;
import java.util.List;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;

/**
 * @author Gábor Csikós
 *
 */
public class AppleFactory {

	private List<Apple> apples;

	public AppleFactory() {
		apples = new ArrayList<>();
		apples.add(createApple());
		apples.add(createApple());
	}

	public List<Apple> getApples() {
		return apples;
	}

	private Apple createApple() {
		Apple apple = new Apple();
		return apple;
	}

}
