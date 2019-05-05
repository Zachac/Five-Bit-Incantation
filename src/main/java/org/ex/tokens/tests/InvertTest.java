package org.ex.tokens.tests;

import org.ex.parser.ExecutionContext;

public class InvertTest implements Test {

	public Test test;

	public InvertTest(Test test) {
		super();
		this.test = test;
	}

	public boolean value(ExecutionContext context) {
		return !test.value(context);
	}
	
}
