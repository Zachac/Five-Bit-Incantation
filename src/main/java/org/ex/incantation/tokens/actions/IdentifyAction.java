package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;

public class IdentifyAction implements Action {

	Identifier identifier;

	public IdentifyAction(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public void execute(ExecutionContext context) {
		context.self().displayInfo(identifier.value(context));
	}
	
}
