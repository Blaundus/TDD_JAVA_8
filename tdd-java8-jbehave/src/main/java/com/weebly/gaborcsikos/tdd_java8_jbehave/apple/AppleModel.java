/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;

/**
 * @author Gábor Csikós
 *
 */
public class AppleModel {
	private AppleRepository repository = new DummyRepository();
	private List<Apple> apples;
	private Map<Long, Apple> inMemoryApples = new HashMap<Long, Apple>();

	public AppleModel() {
		apples = repository.loadApples();
		for (Apple apple : apples) {
			inMemoryApples.put(apple.getID(), apple);
		}
	}

	public List<Apple> getApples() {
		return apples;
	}

	public void removeById(long appleId) {
		apples.removeIf(p -> p.getID() == appleId);
	}

	public void deleteAll() {
		apples.clear();
	}

	public Apple getAppleById(Long Id) {
		return inMemoryApples.get(Id);
	}

}
