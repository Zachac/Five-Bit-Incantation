package org.ex.tokens.identifier;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.literals.NumberValue;
import org.ex.world.entities.Entity;

public class IdIdentifier implements Identifier {

	NumberValue idNumber;

	public IdIdentifier(NumberValue idNumber) {
		super();
		this.idNumber = idNumber;
	}

	public Entity value(ExecutionContext context) {
		return context.getEntity(idNumber.value);
	}
	
}
