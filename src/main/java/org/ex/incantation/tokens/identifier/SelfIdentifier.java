package org.ex.incantation.tokens.identifier;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.world.entities.Entity;

public class SelfIdentifier implements Identifier {

	public Entity value(ExecutionContext context) {
		return context.self();
	}

}
