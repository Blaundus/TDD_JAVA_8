/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
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

/**
 * @author Gábor Csikós
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppleControllerTest {

	private static final int APPLE_ID = 1;

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
		testEmptyList();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listNoApples() {
		testEmptyList();

	}

	@Test
	public void listOneApple() {
		testEmptyList();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
	}

	@Test
	public void listTwoApples() {
		testEmptyList();
		appleController.add(apple);
		appleController.add(anotherApple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 2, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		assertEquals("Apple not added", anotherApple, apples.get(1));
	}

	@Test
	public void deleteAppleByIdFound() {
		testEmptyList();
		appleController.add(apple);
		List<Apple> apples = appleController.list();
		assertEquals("Apple not added", 1, apples.size());
		assertEquals("Apple not added", apple, apples.get(0));
		appleController.deleteById(APPLE_ID);
		testEmptyList();
	}

	@Test
	public void deleteAppleByIdNotFound() {
		testEmptyList();
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

	private void testEmptyList() {
		List<Apple> apples = appleController.list();
		assertTrue("not empty", apples.isEmpty());
	}

}
