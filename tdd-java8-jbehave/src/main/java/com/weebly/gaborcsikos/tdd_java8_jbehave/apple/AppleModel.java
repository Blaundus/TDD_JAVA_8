/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.List;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;

/**
 * @author Gábor Csikós
 *
 */
public class AppleModel {
	private AppleRepository repository = new DummyRepository();
	private List<Apple> apples = repository.loadApples();

	public List<Apple> getApples() {
		return apples;
	}

	public void removeById(long appleId) {
		apples.removeIf(p -> p.getID() == appleId);
	}

	public void deleteAll() {
		apples.clear();
	}

}
