package org.ex.incantation.tokens.identifier;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.literals.NumberValue;
import org.ex.incantation.world.entities.Entity;

public class IdIdentifier implements Identifier {

	public final NumberValue idNumber;

	public IdIdentifier(NumberValue idNumber) {
		super();
		this.idNumber = idNumber;
	}

	public Entity value(ExecutionContext context) {
		Entity result = context.getSelf().resolveEntity(idNumber.value);
		
		if (result == null) {
			result = context.getWorld().find(idNumber.value);
		}
		
		return result;
	}
	
}
