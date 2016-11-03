/**
 * 
 */
package com.weebly.gaborcsikos.tdd_java8_jbehave.apple;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Color;
import com.weebly.gaborcsikos.tdd_java8_jbehave.apple.api.Type;

/**
 * @author Gábor Csikós
 *
 */
public class Apple implements Comparable<Apple> {

	public static final long MINIMAL_ID = 0;

	private static final AtomicLong count = new AtomicLong(MINIMAL_ID);
	private Long ID;
	private Color color;
	private Type type;
	private LocalDate packaged;
	private LocalDateTime examined;

	public Apple() {
		ID = count.getAndIncrement();
		examined = LocalDateTime.now();
		packaged = examined.toLocalDate();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((examined == null) ? 0 : examined.hashCode());
		result = prime * result + ((packaged == null) ? 0 : packaged.hashCode());
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
		if (examined == null) {
			if (other.examined != null)
				return false;
		} else if (!examined.equals(other.examined))
			return false;
		if (packaged == null) {
			if (other.packaged != null)
				return false;
		} else if (!packaged.equals(other.packaged))
			return false;
		if (type != other.type)
			return false;
		return true;
	}

	@Override
	public int compareTo(Apple o) {
		return this.ID.compareTo(o.getID());
	}

	public LocalDate getPackaged() {
		return packaged;
	}

	public void setPackaged(LocalDate packaged) {
		this.packaged = packaged;
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

	public Long getID() {
		return ID;
	}

	public LocalDateTime getExamined() {
		return examined;
	}

	public void setExamined(LocalDateTime examined) {
		this.examined = examined;
	}

}
