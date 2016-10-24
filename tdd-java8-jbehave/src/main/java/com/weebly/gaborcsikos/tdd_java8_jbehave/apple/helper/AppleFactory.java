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

	public static List<Apple> getApples() {
		List<Apple> apples = new ArrayList<>();
		apples.add(createApple());
		apples.add(createApple());
		return apples;
	}

	private static Apple createApple() {
		Apple apple = new Apple();
		return apple;
	}

}
