/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;

/**
 * @author Gábor Csikós
 *
 */
public class AppleTest {

	@Test
	public void idIncrement() {
		Long appleId0 = new Apple().getID();
		Long appleId1 = new Apple().getID();
		appleId0++;
		assertEquals("Apple appleId0 not incremented", appleId0, appleId1);

	}

	@Test
	public void idNotSame() {
		Long appleId0 = new Apple().getID();
		Long appleId1 = new Apple().getID();
		assertFalse(appleId0.equals(appleId1));
	}

}
