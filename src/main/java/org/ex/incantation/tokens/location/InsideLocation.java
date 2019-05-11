package org.ex.incantation.tokens.location;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.utils.ArrayUtils;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.entities.Entity;

public class InsideLocation implements Location {

	public final Identifier identifier;

	public InsideLocation(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public Entity[] find(ExecutionContext context, Type type) {
		return ArrayUtils.getMatching(identifier.value(context).contents(), type);
	}

	public Position position(ExecutionContext context) {
		return identifier.value(context).getPosition();
	}
	
}
