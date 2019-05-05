package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.tests.Test;

public class IfAction implements Action {

	public Test test;
	public Action action;
	
	public IfAction(Test test, Action action) {
		super();
		this.test = test;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		if (test.value(context)) {
			action.execute(context);
		}
	}
}
