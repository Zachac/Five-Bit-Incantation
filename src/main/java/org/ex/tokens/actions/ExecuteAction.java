package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;

public class ExecuteAction implements Action {

	Identifier identifier;

	public ExecuteAction(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public void execute(ExecutionContext context) {
		identifier.value(context).getInscription(context).execute(context);
	}
	
}
