/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
public class AppleBuilder {

	private Apple apple;

	public AppleBuilder() {
		apple = new Apple();
	}

	public AppleBuilder withColor(Color color) {
		this.apple.setColor(color);
		return this;
	}

	public AppleBuilder withType(Type type) {
		this.apple.setType(type);
		return this;
	}

	public Apple build() {
		return apple;
	}

}
