package org.ex.incantation.tokens.identifier;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.literals.NumberValue;
import org.ex.incantation.world.entities.Entity;

public class IdIdentifier implements Identifier {

	NumberValue idNumber;

	public IdIdentifier(NumberValue idNumber) {
		super();
		this.idNumber = idNumber;
	}

	public Entity value(ExecutionContext context) {
		Entity result = context.self().resolveEntity(idNumber.value);
		
		if (result == null) {
			result = context.world().find(idNumber.value);
		}
		
		return result;
	}
	
}
