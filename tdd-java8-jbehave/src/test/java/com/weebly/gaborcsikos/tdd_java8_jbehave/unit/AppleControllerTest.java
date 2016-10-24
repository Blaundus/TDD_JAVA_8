/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleModel;
import com.weebly.gaborcsikos.tdd_java8_jbehave.integration.AppleIntegrationTest;

/**
 * @author Gábor Csikós Actually this doesn't need to exists. {@link AppleModel}
 *         is unit tested, and there is integration tests in
 *         {@link AppleIntegrationTest}
 */
@RunWith(MockitoJUnitRunner.class)
public class AppleControllerTest {

	private static final long APPLE_ID = 1;

	@InjectMocks
	private AppleController appleController;

	@Mock
	private Apple apple;
	@Mock
	private Apple anotherApple;

	@Before
	public void initAndMock() {
		when(apple.getID()).thenReturn(APPLE_ID);
	}

	@Test
	public void addApple() {
		eraseApples();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listOneApple() {
		eraseApples();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listTwoApples() {
		eraseApples();
		appleController.add(apple);
		appleController.add(anotherApple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 2, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		assertEquals("Apple not added", anotherApple, apples.get(1));
	}

	@Test
	public void deleteAppleByIdFound() {
		eraseApples();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		appleController.deleteById(APPLE_ID);
		eraseApples();
	}

	@Test
	public void deleteAppleByIdNotFound() {
		eraseApples();
		appleController.add(apple);
		appleController.add(anotherApple);
		List<Apple> apples = null;
		apples = appleController.list();
		assertEquals("Apple not added", 2, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		assertEquals("Apple not added", anotherApple, apples.get(1));

		apples = appleController.list();
		appleController.deleteById(APPLE_ID + 1);
		assertEquals("Apple not added", 2, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		assertEquals("Apple not added", anotherApple, apples.get(1));
	}

	private void eraseApples() {
		appleController.deleteAll();
	}

}
