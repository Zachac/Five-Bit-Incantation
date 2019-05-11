package org.ex.incantation.parser;

import static org.ex.incantation.tokens.literals.LitteralToken.ONE;
import static org.ex.incantation.tokens.literals.LitteralToken.ZERO;

import java.util.Iterator;
import java.util.Objects;

import org.ex.incantation.exception.UnrecognizableTokenException;
import org.ex.incantation.tokens.Token;
import org.ex.incantation.tokens.literals.LitteralToken;

public class Tokenizer implements Iterable<Token>, Iterator<Token> {
	
	private static final LitteralToken[] TOKENS = LitteralToken.values();
	
	Iterator<String> s;
	
	public Tokenizer(Iterator<String> s) {
		this.s = Objects.requireNonNull(s);
	}

	public Token next() {
		if (!s.hasNext()) {
			throw new IllegalStateException();
		}
		
		String value = s.next();
		
		for (LitteralToken t : TOKENS) {
			if (t != ONE && t != ZERO && t.value.equalsIgnoreCase(value)) {
				return t;
			}
		}
		
		try {
			return new org.ex.incantation.tokens.literals.NumberValue(Integer.parseInt(value, 2));			
		} catch (NumberFormatException e) {
			throw new UnrecognizableTokenException(value);
		}
	}
	
	public boolean hasNext() {
		return s.hasNext();
	}

	public Iterator<Token> iterator() {
		return this;
	}
	
}
