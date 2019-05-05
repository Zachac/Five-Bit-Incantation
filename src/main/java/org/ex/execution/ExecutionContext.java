package org.ex.execution;

import org.ex.world.entities.Entity;

public class ExecutionContext {

	AforementionStack aforementioned;
	

	public Entity getEntity(int value) {
		// TODO
		
		return null;
	}
	
	public Entity getSelf(int value) {
		// TODO
		
		return null;
	}
	
	public Entity getAforementioned(int value) {
		return aforementioned.get(value);
	}

	public void push(Entity e) {
		aforementioned.push(e);
	}
	
}
