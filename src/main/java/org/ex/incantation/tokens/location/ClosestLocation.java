package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class ClosestLocation extends AbstractPositionalLocation {
	
	public Entity[] find(ExecutionContext context, Type type) {
		return find(context.getWorld(), context.getSelf().getPosition(), type);
	}

	public Position position(ExecutionContext context) {
		return position(context.getWorld(), context.getSelf().getPosition());
	}

}
