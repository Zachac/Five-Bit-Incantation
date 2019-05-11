package org.ex.incantation.parser;

import java.util.Iterator;
import java.util.Scanner;

public class CarrigeReturnScanner implements Iterator<String> {

	private Scanner input;
	private Scanner currentLine;

	public CarrigeReturnScanner(Scanner input) {
		this.input = input;
		this.currentLine = new Scanner("");
	}
	
	public boolean hasNext() {
		return currentLine.hasNext();
	}

	public String next() {
		return currentLine.next();
	}

	public void carrigeReturn() {
		currentLine = new Scanner(input.nextLine());
	}
}
