/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.AppleRepository;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.MixType;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
// Basically the model should have a service, but now this is OK
public class AppleModel {

	public static final String NO_APPLES_FOUND = "Apple not found";
	public static final String ILLEGAL_STATE = "Apples with same ID found";
	private static final int BAGSIZE = 10;
	private static final int YELLOW_APPLE_BAG_SIZE = 6;
	private static final int GREEN_APPLE_BAG_SIZE = 8;
	private static final int RED_APPLE_BAG_SIZE = 4;
	private static final int RED_APPLE_BAG_SIZE_ANTI_DOCTOR = 2;

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

	public List<List<Apple>> useMixType(MixType mixType) {
		List<List<Apple>> result = new ArrayList<>();
		List<Apple> bag = new ArrayList<>();
		int counter = 0;
		if (MixType.RED_APPLE == mixType) {
			List<Apple> applesToFilter = apples.stream().filter(p -> Color.RED == p.getColor())
					.collect(Collectors.toList());
			for (Apple apple : applesToFilter) {
				bag.add(apple);
				counter++;
				if (counter == BAGSIZE) {
					counter = 0;
					result.add(bag);
					bag.clear();
				}
			}

		} else if (MixType.AUTOMN == mixType) {
			List<Apple> redApples = apples.stream().filter(p -> Color.RED == p.getColor()).collect(Collectors.toList());
			List<Apple> yelloApples = apples.stream().filter(p -> Color.YELLOW == p.getColor())
					.collect(Collectors.toList());
			int bags = 0;
			for (Apple yellowApple : yelloApples) {
				bag.add(yellowApple);
				counter++;
				if (counter == YELLOW_APPLE_BAG_SIZE) {
					counter = 0;
					for (int i = bags * RED_APPLE_BAG_SIZE; i < redApples.size(); i++) {
						bag.add(redApples.get(i));
						counter++;
						if (counter == RED_APPLE_BAG_SIZE) {
							counter = 0;
							result.add(bag);
							bag.clear();
							bags++;
							break;
						}
					}

				}
			}
		} else if (MixType.ANTI_DOCTOR == mixType) {
			List<Apple> redApples = apples.stream().filter(p -> Color.RED == p.getColor()).collect(Collectors.toList());
			List<Apple> greenApples = apples.stream().filter(p -> Color.GREEN == p.getColor())
					.collect(Collectors.toList());
			int bags = 0;
			for (Apple greenApple : greenApples) {
				bag.add(greenApple);
				counter++;
				if (counter == GREEN_APPLE_BAG_SIZE) {
					counter = 0;
					for (int i = bags * RED_APPLE_BAG_SIZE_ANTI_DOCTOR; i < redApples.size(); i++) {
						bag.add(redApples.get(i));
						counter++;
						if (counter == RED_APPLE_BAG_SIZE_ANTI_DOCTOR) {
							counter = 0;
							result.add(bag);
							bag.clear();
							bags++;
							break;
						}
					}

				}
			}
		}
		return result;
	}

}
