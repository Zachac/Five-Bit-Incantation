package org.ex.incantation.tokens.elements;

public class AirElement implements Element {

	@Override
	public boolean matches(Element value) {
		return value instanceof AirElement;
	}

}
