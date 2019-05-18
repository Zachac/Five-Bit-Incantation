package org.ex.incantation.parser.tokenizer.bits;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.ex.incantation.parser.tokenizer.Lexicon;
import org.ex.incantation.tokens.Token;

/**
 * A class to parse incoming bits into tokens
 */
public class BitParser implements Iterator<Token> {

	private Lexicon<Integer> lex;
	private Iterator<Integer> scanner;
	private Token nextElement;

	public BitParser(Iterator<Integer> incomingValues, Lexicon<Integer> lex) {
		this.lex = lex;
		this.scanner = incomingValues;
	}

	@Override
	public boolean hasNext() {
		if (nextElement != null) {
			return true;
		} else {
			return (nextElement = parse()) != null;
		}
	}

	@Override
	public Token next() throws NoSuchElementException {
		Token t = nextElement;
		
		if (nextElement != null) {
			nextElement = null;
		} else if ((t = parse()) == null) {
			throw new NoSuchElementException();
		}
		
		return t;
	}

	/**
	 * Consume elements until a 0 is reached. At which point, translate the element
	 * for which all elements coming after it (and the element itself) are supersets
	 * of the bitsets. Return the translation result if not null or continue  parsing.
	 * @return A token or null if the scanner does not have any next elements.
	 */
	public Token parse() {
		Token result = null;

		int element = 0;
		int lastElement = 0;
		int nextElement;
		
		do {			
			while (scanner.hasNext() && (nextElement = scanner.next()) != 0) {
				if ((lastElement | nextElement) != lastElement) {
					element = nextElement;
				}
				
				lastElement = nextElement;
			}
			
			result = lex.translate(element);
		} while (result == null && scanner.hasNext());
		
		return result;
	}
}
