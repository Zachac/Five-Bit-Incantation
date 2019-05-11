package org.ex.incantation.tokens.identifier;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.world.entities.Entity;

public interface Identifier {
	
	public Entity value(ExecutionContext context);
	
}
