package org.ex.incantation.tokens.elements;

public class FireElement implements Element {

	@Override
	public boolean matches(Element value) {
		return value instanceof FireElement;
	}

}
