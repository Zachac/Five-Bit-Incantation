package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;

public class AdditionallyAction implements Action {

	public Action action1;
	public Action action2;
	
	public AdditionallyAction(Action action1, Action action2) {
		super();
		this.action1 = action1;
		this.action2 = action2;
	}

	public void execute(ExecutionContext context) {
		action1.execute(context);
		action2.execute(context);
	}
	
}
