package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;

public class ExecuteAction implements Action {

	public final Identifier identifier;

	public ExecuteAction(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public void execute(ExecutionContext context) {
		identifier.value(context).getInscription(context).execute(context);
	}
	
}
