/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.List;
import java.util.stream.Collectors;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
// Basically the model should have a service, but now this is OK
public class AppleModel {

	public static final String NO_APPLES_FOUND = "Apple not found";
	public static final String ILLEGAL_STATE = "Apples with same ID found";

	private List<Apple> apples;

	public AppleModel(AppleRepository repository) {
		apples = repository.loadApples();
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

	// These methods needs integration test
	public long countByColor(Color color) {
		return apples.stream().filter(p -> color == p.getColor()).count();
	}

	public long countByType(Type type) {
		return apples.stream().filter(p -> type == p.getType()).count();
	}

}
