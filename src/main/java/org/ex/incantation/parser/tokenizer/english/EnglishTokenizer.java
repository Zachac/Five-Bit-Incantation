package org.ex.incantation.parser.tokenizer.english;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import org.ex.incantation.parser.tokenizer.Lexicon;
import org.ex.incantation.parser.tokenizer.Tokenizer;
import org.ex.incantation.tokens.Token;

public class EnglishTokenizer implements Tokenizer {

	private Lexicon<String> lex;
	private Iterator<String> s;
	
	public EnglishTokenizer(Iterator<String> s) {
		this.s = Objects.requireNonNull(s);
		this.lex = new DefaultEnglishLexicon();
	}

	public Token next() throws NoSuchElementException {
		if (!s.hasNext()) {
			throw new NoSuchElementException();
		}
		
		return lex.translate(s.next());
	}
	
	public boolean hasNext() {
		return s.hasNext();
	}
}
