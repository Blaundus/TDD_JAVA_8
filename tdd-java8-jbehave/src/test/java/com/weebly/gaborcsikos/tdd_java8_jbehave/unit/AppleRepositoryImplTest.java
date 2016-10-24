package com.weebly.gaborcsikos.tdd_java8_jbehave.unit;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.DummyRepository;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper.AppleFactory;

/**
 * @author Gábor Csikós
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AppleRepositoryImplTest {

	@InjectMocks
	public DummyRepository repository;

	@Test
	public void loadApplesEmpty() {
		List<Apple> result = repository.loadApples();
		assertEquals(result, AppleFactory.getApples());
	}

}
