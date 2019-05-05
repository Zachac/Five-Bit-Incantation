package org.ex.tokens.location;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.types.Type;
import org.ex.world.Position;
import org.ex.world.entities.Entity;

public interface Location {

	public Entity[] find(Type type);

	public Position position(ExecutionContext context);

}
