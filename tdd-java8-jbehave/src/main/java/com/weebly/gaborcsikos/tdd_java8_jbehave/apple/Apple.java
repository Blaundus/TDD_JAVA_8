/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.util.concurrent.atomic.AtomicLong;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
public class Apple implements Comparable<Apple> {

	public static final int MINIMAL_ID = 0;

	private static final AtomicLong count = new AtomicLong(MINIMAL_ID);
	private Long ID;
	private Color color;
	private Type type;

	public Apple() {
		ID = count.getAndIncrement();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Apple other = (Apple) obj;
		if (color != other.color)
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	public Long getID() {
		return ID;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	@Override
	public int compareTo(Apple o) {
		return this.ID.compareTo(o.getID());
	}

}
