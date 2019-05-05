package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;

public class IdentifyAction implements Action {

	Identifier identifier;

	public IdentifyAction(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public void execute(ExecutionContext context) {
		// TODO Auto-generated method stub
		identifier.value(context);
	}
	
}
