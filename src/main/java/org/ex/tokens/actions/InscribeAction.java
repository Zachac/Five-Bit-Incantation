package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;

public class InscribeAction implements Action {

	Identifier identifier;
	Action action;

	public InscribeAction(Identifier identifier, Action action) {
		super();
		this.identifier = identifier;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		identifier.value(context).inscribe(context, action);
	}
	
}
