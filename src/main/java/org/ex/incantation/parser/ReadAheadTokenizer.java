package org.ex.incantation.parser;

import java.util.Iterator;

import org.ex.incantation.tokens.Token;

public class ReadAheadTokenizer extends Tokenizer {

	private Token t;
	
	public ReadAheadTokenizer(Iterator<String> s) {
		super(s);
	}
	
	@Override
	public Token next() {
		if (t != null) {
			Token result = t;
			t = null;
			return result;
		}
		
		return super.next();
	}
	
	@Override
	public boolean hasNext() {
		if (t != null) {
			return true;
		}
		
		return super.hasNext();
	}
	
	public Token peek() {
		if (t != null) {
			return t;
		}
		
		return hasNext() ? t = next() : null; 
	}

}
