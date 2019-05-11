package org.ex.incantation.tokens.tests;

import org.ex.incantation.execution.ExecutionContext;

public class InvertTest implements Test {

	public final Test test;

	public InvertTest(Test test) {
		super();
		this.test = test;
	}

	public boolean value(ExecutionContext context) {
		return !test.value(context);
	}
	
}
