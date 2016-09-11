/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Gábor Csikós
 *
 */
public class Apple {

	private static final AtomicInteger count = new AtomicInteger(0);
	private int ID;

	public Apple() {
		ID = count.incrementAndGet();

	}

	public int getID() {
		return ID;
	}

}
