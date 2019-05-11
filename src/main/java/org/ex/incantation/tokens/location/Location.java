package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public interface Location {

	public Entity[] find(ExecutionContext context, Type type);

	public Position position(ExecutionContext context);

}
