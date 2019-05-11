package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;

public class InscribeAction implements Action {

	public final Identifier identifier;
	public final Action action;

	public InscribeAction(Identifier identifier, Action action) {
		super();
		this.identifier = identifier;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		identifier.value(context).inscribe(context, action);
	}
	
}
