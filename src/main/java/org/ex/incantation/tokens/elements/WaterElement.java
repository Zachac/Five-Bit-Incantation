package org.ex.incantation.tokens.elements;

public class WaterElement implements Element {

	@Override
	public boolean matches(Element value) {
		return value instanceof WaterElement;
	}

}
