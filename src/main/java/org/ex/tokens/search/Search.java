package org.ex.tokens.search;

import org.ex.tokens.location.Location;
import org.ex.tokens.types.Type;
import org.ex.world.entities.Entity;

public class Search {

	Type type;
	Location location;
	
	public Search(Type type, Location location) {
		super();
		this.type = type;
		this.location = location;
	}
	
	public Entity[] getEntities() {
		return location.find(type);
	}
}
