package org.ex.exception;

import java.util.NoSuchElementException;

public class UnrecognizableTokenException extends NoSuchElementException  {

	private static final long serialVersionUID = -4391080339045905973L;
	
	public UnrecognizableTokenException(String s) {
		super(s);
	}
	
}
