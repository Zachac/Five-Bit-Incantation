package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.tests.Test;

public class IfAction implements Action {

	public final Test test;
	public final Action action;
	
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
