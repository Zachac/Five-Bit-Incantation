package org.ex.tokens.identifier;

import org.ex.parser.ExecutionContext;
import org.ex.world.entities.Entity;

public interface Identifier {
	
	public Entity value(ExecutionContext context);
	
}
