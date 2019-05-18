package org.ex.incantation.parser.tokenizer;

import org.ex.incantation.tokens.Token;

public class ReadAheadTokenizer implements Tokenizer {

	private Tokenizer tokenizer;
	private Token t;
	
	public ReadAheadTokenizer(Tokenizer t) {
		this.tokenizer = t;
	}
	
	@Override
	public Token next() {
		if (t != null) {
			Token result = t;
			t = null;
			return result;
		}
		
		return tokenizer.next();
	}
	
	@Override
	public boolean hasNext() {
		if (t != null) {
			return true;
		}
		
		return tokenizer.hasNext();
	}
	
	public Token peek() {
		if (t != null) {
			return t;
		}
		
		return hasNext() ? t = next() : null; 
	}

}
