/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.List;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper.AppleFactory;

/**
 * @author Gábor Csikós
 *
 */
public class DummyRepository implements AppleRepository {

	private List<Apple> apples;
	private AppleFactory factory;

	public DummyRepository() {
		factory = new AppleFactory();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleRepository#loadApples
	 * ()
	 */
	@Override
	public List<Apple> loadApples() {
		if (apples == null) {
			apples = factory.getApples();
		}
		return apples;
	}

}
