package org.ex.incantation.execution;

import java.util.Arrays;
import java.util.List;

import org.ex.incantation.world.entities.Entity;

public class AforementionStack {

	private static final int MAX_MEMORY = 100;
	
	private List<Entity> entities = Arrays.asList(new Entity[MAX_MEMORY]);
	private int offset;
	
	public Entity get(int x) {
		return entities.get((offset - x) % MAX_MEMORY);
	}
	
	public void push(Entity e) {
		entities.set(++offset, e);
		offset = offset % MAX_MEMORY;
	}
}
