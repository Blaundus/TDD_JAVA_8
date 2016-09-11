/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;

/**
 * @author Gábor Csikós
 * 
 */
public class Application {

	private AppleController controller = new AppleController();

	public void start() {

	}

	public void exit() {
		controller.exit();

	}

}
