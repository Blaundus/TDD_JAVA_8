/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api;

import java.util.List;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.Apple;

/**
 * Repository for apples
 * 
 * @author Gábor Csikós
 *
 */
public interface AppleRepository {

	List<Apple> loadApples();

}
