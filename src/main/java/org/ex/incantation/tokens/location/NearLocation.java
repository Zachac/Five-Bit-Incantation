package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class NearLocation implements Location {

	public Identifier identifier;

	public NearLocation(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public Entity[] find(ExecutionContext context, Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Position position(ExecutionContext context) {
		return identifier.value(context).getPosition();
	}
	
}
