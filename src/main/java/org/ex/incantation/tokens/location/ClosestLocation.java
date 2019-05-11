package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class ClosestLocation implements Location {

	private static final Entity[] NO_FOUND_ENTITIES = new Entity[0];
	
	public Entity[] find(ExecutionContext context, Type type) {
		Entity[] closest = context.world().findClosest(context.self().getPosition(), type, 2);
		
		if (closest.length < 2) {
			return NO_FOUND_ENTITIES;
		}
		
		return new Entity[] { closest[1] };
	}

	public Position position(ExecutionContext context) {
		Entity[] closest = context.world().findClosest(context.self().getPosition(), 2);

		if (closest.length < 2) {
			return context.self().getPosition();
		}
		
		return closest[1].getPosition();
	}

}
