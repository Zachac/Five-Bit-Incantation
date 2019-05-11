package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.tests.Test;

public class WhileAction implements Action {

	public Test test;
	public Action action;

	public WhileAction(Test test, Action action) {
		super();
		this.test = test;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		while (test.value(context)) {
			action.execute(context);
		}
	}
}
