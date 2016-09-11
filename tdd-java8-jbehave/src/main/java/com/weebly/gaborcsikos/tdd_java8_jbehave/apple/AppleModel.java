/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Gábor Csikós
 *
 */
public class AppleModel {

	private final List<Apple> apples = new ArrayList<Apple>();

	public List<Apple> getApples() {
		return apples;
	}

}
