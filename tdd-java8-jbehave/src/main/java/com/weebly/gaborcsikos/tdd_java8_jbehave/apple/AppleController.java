/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.time.LocalDate;
import java.util.List;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.MixType;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
public class AppleController {

	private AppleModel model;

	public AppleController() {
		model = new AppleModel(new DummyRepository());
	}

	public void exit() {
		System.exit(0);
	}

	public void deleteAll() {
		model.deleteAll();
	}

	public List<Apple> list() {
		return model.getApples();
	}

	public void add(Apple apple) {
		model.getApples().add(apple);

	}

	public void deleteById(long appleId) {
		model.removeById(appleId);

	}

	public Apple getAppleById(Long id) {
		return model.getAppleById(id);
	}

	public long countByColor(Color color) {
		return model.countByColor(color);
	}

	public long countByType(Type type) {
		return model.countByType(type);

	}

	public List<List<Apple>> useMixType(MixType mixType) {
		return model.useMixType(mixType);
	}

	public LocalDate getBestBeforeDate(Apple apple) {
		return model.getBestBeforeDate(apple);
	}

}
