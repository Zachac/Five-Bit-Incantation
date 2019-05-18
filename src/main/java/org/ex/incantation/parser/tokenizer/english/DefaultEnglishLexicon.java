package org.ex.incantation.parser.tokenizer.english;

import static org.ex.incantation.tokens.literals.LitteralToken.ONE;
import static org.ex.incantation.tokens.literals.LitteralToken.ZERO;

import org.ex.incantation.exception.UnrecognizableTokenException;
import org.ex.incantation.parser.tokenizer.Lexicon;
import org.ex.incantation.tokens.Token;
import org.ex.incantation.tokens.literals.LitteralToken;

public class DefaultEnglishLexicon implements Lexicon<String> {

	private static final LitteralToken[] TOKENS = LitteralToken.values();

	@Override
	public Token translate(String value) {
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

}
