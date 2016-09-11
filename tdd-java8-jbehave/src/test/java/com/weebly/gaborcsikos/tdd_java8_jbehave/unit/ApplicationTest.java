/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.weebly.gaborcsikos.tdd_java8_jbehave.Application;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;

/**
 * @author Gábor Csikós
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ApplicationTest {

	@InjectMocks
	private Application application;

	@Mock
	private AppleController appleController;

	@Test
	public void applicationStart() {
		try {
			application.start();
		} catch (Exception e) {
			fail();
		}

	}

	@Test
	public void exit() {
		application.exit();
		Mockito.verify(appleController, Mockito.times(1)).exit();
	}

}
