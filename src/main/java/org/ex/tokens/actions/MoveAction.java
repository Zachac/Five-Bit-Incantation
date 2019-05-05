package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;
import org.ex.tokens.location.Location;

public class MoveAction implements Action {

	public Identifier identifier;
	public Location location;
	
	public MoveAction(Identifier identifier, Location location) {
		super();
		this.identifier = identifier;
		this.location = location;
	}

	public void execute(ExecutionContext context) {
		// TODO Auto-generated method stub
		identifier.value(context).move(location.position(context));
	}
	
}
