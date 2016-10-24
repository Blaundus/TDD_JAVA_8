package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.helper;

import org.junit.Assert;
import org.junit.Test;

public class AppleFactoryTest {

	@Test
	public void test() {
		Assert.assertEquals(2, AppleFactory.getApples().size());
	}

}
