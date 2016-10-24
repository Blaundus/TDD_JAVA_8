package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.AppleModel;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper.AppleFactory;

/**
 * @author Gábor Csikós
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppleModelTest {

	@InjectMocks
	private AppleModel model;

	@Test
	public void getApplesTest() {
		List<Apple> apples = model.getApples();
		assertEquals(AppleFactory.getApples(), apples);
	}

	@Test
	public void removeByIdTestidFound() {
		List<Apple> apples = model.getApples();
		Assert.assertFalse(apples.isEmpty());
		int sizeNow = apples.size();

		long appleTorRemoveId = apples.get(0).getID();

		model.removeById(appleTorRemoveId);
		assertEquals(sizeNow - 1, model.getApples().size());
	}

	@Test
	public void removeByIdTestidNotFound() {
		List<Apple> apples = model.getApples();
		Assert.assertFalse(apples.isEmpty());
		int sizeNow = apples.size();

		model.removeById(Apple.MINIMAL_ID - 1);
		assertEquals(sizeNow, model.getApples().size());
	}

}
