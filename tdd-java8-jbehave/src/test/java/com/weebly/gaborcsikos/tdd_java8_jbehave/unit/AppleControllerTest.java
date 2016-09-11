/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleController;

/**
 * @author Gábor Csikós
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppleControllerTest {

	@InjectMocks
	private AppleController appleController;

	@Mock
	private Apple apple;
	@Mock
	private Apple anotherApple;

	@Test
	public void addApple() {
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listNoApples() {
		List<Apple> apples = appleController.list();
		assertTrue("not empty", apples.isEmpty());

	}

	@Test
	public void listOneApple() {
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listTwoApples() {
		appleController.add(apple);
		appleController.add(anotherApple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 2, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		assertEquals("Apple not added", anotherApple, apples.get(1));
	}
}
