/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.fail;

import org.junit.Test;

import com.weebly.gaborcsikos.tdd_java8_jbehave.Application;

/**
 * @author Gábor Csikós
 *
 */
public class ApplicationTest {

	private Application application = new Application();

	@Test
	public void applicationStart() {
		try {
			application.start();
		} catch (Exception e) {
			fail();
		}

	}

}
