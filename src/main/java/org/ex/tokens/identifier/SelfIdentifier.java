package org.ex.tokens.identifier;

import org.ex.parser.ExecutionContext;
import org.ex.world.entities.Entity;

public class SelfIdentifier implements Identifier {

	public Entity value(ExecutionContext context) {
		return context.self();
	}

}
