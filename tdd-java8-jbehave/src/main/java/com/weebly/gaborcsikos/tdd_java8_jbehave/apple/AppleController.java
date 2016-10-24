/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.List;

/**
 * @author Gábor Csikós
 *
 */
public class AppleController {

	private AppleModel model = new AppleModel();

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

}
