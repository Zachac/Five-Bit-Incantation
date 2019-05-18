package org.ex.incantation.parser.tokenizer;

import java.util.Iterator;

import org.ex.incantation.tokens.Token;

public interface Tokenizer extends Iterable<Token>, Iterator<Token> {
	
	public default Iterator<Token> iterator() {
		return this;
	}
	
}
