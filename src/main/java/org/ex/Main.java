package org.ex;

import java.util.Scanner;

import org.ex.exception.UnexpectedTokenException;
import org.ex.parser.CarrigeReturnScanner;
import org.ex.parser.Parser;
import org.ex.parser.ReadAheadTokenizer;

public class Main {
	
	public static void main(String[] args) throws UnexpectedTokenException {

		CarrigeReturnScanner input = new CarrigeReturnScanner(new Scanner(System.in));
		ReadAheadTokenizer tokenizer = new ReadAheadTokenizer(input);

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
