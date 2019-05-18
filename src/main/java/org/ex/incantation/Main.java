package org.ex.incantation;

import java.util.Scanner;

import org.ex.incantation.exception.UnexpectedTokenException;
import org.ex.incantation.parser.CarrigeReturnScanner;
import org.ex.incantation.parser.Parser;
import org.ex.incantation.parser.tokenizer.ReadAheadTokenizer;
import org.ex.incantation.parser.tokenizer.english.EnglishTokenizer;

public class Main {
	
	public static void main(String[] args) throws UnexpectedTokenException {

		CarrigeReturnScanner input = new CarrigeReturnScanner(new Scanner(System.in));
		ReadAheadTokenizer tokenizer = new ReadAheadTokenizer(new EnglishTokenizer(input));

		input.carrigeReturn();
		
		while (input.hasNext()) {
			try {
				System.out.println(Parser.recognizeAction(tokenizer));				
			} catch (Exception e) {
				e.printStackTrace();
			}

			input.carrigeReturn();
		}
		
	}
	
}
