package org.ex.tokens.identifier;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.literals.NumberValue;
import org.ex.world.entities.Entity;

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
