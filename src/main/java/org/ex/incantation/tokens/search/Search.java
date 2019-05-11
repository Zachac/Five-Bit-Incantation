package org.ex.incantation.tokens.search;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.location.Location;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.entities.Entity;

public class Search {

	Type type;
	Location location;
	
	public Search(Type type, Location location) {
		super();
		this.type = type;
		this.location = location;
	}
	
	public Entity[] getEntities(ExecutionContext context) {
		return location.find(context, type);
	}
}
