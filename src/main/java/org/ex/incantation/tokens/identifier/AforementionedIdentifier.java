package org.ex.incantation.tokens.identifier;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.literals.NumberValue;
import org.ex.incantation.world.entities.Entity;

public class AforementionedIdentifier implements Identifier {

	NumberValue idNumber;

	public AforementionedIdentifier(NumberValue idNumber) {
		super();
		this.idNumber = idNumber;
	}

	public Entity value(ExecutionContext context) {
		return context.getAforementioned(idNumber.value);
	}
	
}
