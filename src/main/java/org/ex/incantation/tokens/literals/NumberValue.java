package org.ex.incantation.tokens.literals;

import org.ex.incantation.tokens.Token;

public class NumberValue implements Token {

	public final int value;

	public NumberValue(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return Integer.toString(value);
	}
	
}
