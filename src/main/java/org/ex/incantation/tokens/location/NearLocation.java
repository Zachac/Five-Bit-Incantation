package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class NearLocation extends AbstractPositionalLocation {

	public final Identifier identifier;

	public NearLocation(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public Entity[] find(ExecutionContext context, Type type) {
		return find(context.getWorld(), identifier.value(context).getPosition(), type);
	}

	public Position position(ExecutionContext context) {
		return position(context.getWorld(), identifier.value(context).getPosition());
	}
	
}
