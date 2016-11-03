/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;

/**
 * @author Gábor Csikós
 *
 */
public class AppleMatcher extends TypeSafeMatcher<Apple> {

	private Apple actual;

	public AppleMatcher(Apple apple) {
		this.actual = apple;
	}

	public AppleMatcher(AppleBuilder apple) {
		this.actual = apple.build();
	}

	@Override
	public void describeTo(Description description) {
		description.appendText("should match ID:").appendText(actual.getID().toString())
				.appendText("should match color ").appendText(actual.getColor().toString())
				.appendText("should match type ").appendText(actual.getType().toString())
				.appendText("should match packaging ").appendText(actual.getPackaged().toString())
				.appendText("should match examination date ").appendText(actual.getExamined().toString());

	}

	@Override
	protected boolean matchesSafely(Apple item) {
		return actual.equals(item);
	}

}
