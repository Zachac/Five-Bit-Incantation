package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.location.Location;

public class MoveAction implements Action {

	public final Identifier identifier;
	public final Location location;
	
	public MoveAction(Identifier identifier, Location location) {
		super();
		this.identifier = identifier;
		this.location = location;
	}

	public void execute(ExecutionContext context) {
		identifier.value(context).move(location.position(context));
	}
	
}
