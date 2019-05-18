package org.ex.incantation.parser.tokenizer;

import org.ex.incantation.tokens.Token;

public interface Lexicon<T> {

	public Token translate(T input);
	
}
