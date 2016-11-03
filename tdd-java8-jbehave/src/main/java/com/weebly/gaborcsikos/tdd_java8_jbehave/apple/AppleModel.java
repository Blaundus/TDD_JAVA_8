/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.List;
import java.util.stream.Collectors;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;

/**
 * @author Gábor Csikós
 *
 */
public class AppleModel {

	public static final String NO_APPLES_FOUND = "Apple not found";
	public static final String ILLEGAL_STATE = "Apples with same ID found";

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

	public Apple getAppleById(Long Id) {
		List<Apple> result = apples.stream().filter(p -> p.getID() == Id).collect(Collectors.toList());
		if (result.isEmpty()) {
			// This was a decision to return null
			return null;
		}
		if (result.size() > 1) {
			throw new IllegalStateException(ILLEGAL_STATE);
		}
		return result.get(0);
	}

}
