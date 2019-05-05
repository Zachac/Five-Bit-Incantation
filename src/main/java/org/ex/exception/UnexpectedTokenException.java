package org.ex.exception;

import org.ex.tokens.Token;

public class UnexpectedTokenException extends Exception {

	private static final long serialVersionUID = 6503598299076962312L;
	
	public final Token token;

	public UnexpectedTokenException(Token t) {
		super(t.toString());
		this.token = t;
	}
	
}
