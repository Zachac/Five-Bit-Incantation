package org.ex.incantation.tokens.location;

import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.Position;
import org.ex.incantation.world.World;
import org.ex.incantation.world.entities.Entity;

public abstract class AbstractPositionalLocation implements Location {

	private static final Entity[] NO_FOUND_ENTITIES = new Entity[0];
	
	public Entity[] find(World w, Position p, Type type) {
		Entity[] closest = w.findClosest(p, type, 2);
		
		if (closest.length < 2) {
			return NO_FOUND_ENTITIES;
		}
		
		return new Entity[] { closest[1] };
	}

	public Position position(World w, Position p) {
		Entity[] closest = w.findClosest(p, 2);

		if (closest.length < 2) {
			return p;
		}
		
		return closest[1].getPosition();
	}

}
