package org.ex.incantation.execution;

import org.ex.incantation.world.World;
import org.ex.incantation.world.entities.Entity;

public class ExecutionContext {

	private final AforementionStack aforementioned;
	private final Entity self;
	private final World world;

	public ExecutionContext(World world, Entity executor) {
		this.self = executor;
		this.aforementioned = new AforementionStack();
		this.world = world;
	}
	
	/**
	 * @return the world this was executed in.
	 */
	public World getWorld() {
		return world;
	}

	/**
	 * @return the executor of the context.
	 */
	public Entity getSelf() {
		return self;
	}
	
	/**
	 * Get the entity mentioned n times ago. Where n=0 is the last entity mentioned.
	 */
	public Entity getAforementioned(int value) {
		return aforementioned.get(value);
	}

	/**
	 * Push the entity onto the stack of entities recently mentioned.
	 */
	public void push(Entity e) {
		aforementioned.push(e);
	}
}
