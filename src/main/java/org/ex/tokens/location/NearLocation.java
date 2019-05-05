package org.ex.tokens.location;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;
import org.ex.tokens.types.Type;
import org.ex.world.Position;
import org.ex.world.entities.Entity;

public class NearLocation implements Location {

	public Identifier identifier;

	public NearLocation(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public Entity[] find(Type type) {
		// TODO Auto-generated method stub
		return null;
	}

	public Position position(ExecutionContext context) {
		return identifier.value(context).getPosition();
	}
	
}
