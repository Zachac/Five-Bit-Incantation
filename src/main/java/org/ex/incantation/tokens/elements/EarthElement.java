package org.ex.incantation.tokens.elements;

public class EarthElement implements Element {

	@Override
	public boolean matches(Element value) {
		return value instanceof EarthElement;
	}

}
