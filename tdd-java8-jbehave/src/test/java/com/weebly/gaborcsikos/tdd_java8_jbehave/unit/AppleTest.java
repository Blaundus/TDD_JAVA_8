/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;

/**
 * @author Gábor Csikós
 *
 */

public class AppleTest {

	@Test
	public void idIncrement() {
		Apple appleId0 = new Apple();
		Apple appleId1 = new Apple();
		assertEquals("Apple appleId0 ID differs", 1, appleId0.getID());
		assertEquals("Apple appleId1 ID differs", 2, appleId1.getID());
	}

}
