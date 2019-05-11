package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.utils.ArrayUtils;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class TouchedLocation implements Location {

	public Entity[] find(ExecutionContext context, Type type) {
		return ArrayUtils.getMatching(context.getSelf().getTouching(), type);
	}

	public Position position(ExecutionContext context) {
		return context.getSelf().getTouching()[0].getPosition();
	}

}
