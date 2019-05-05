package org.ex.world.entities;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.actions.Action;
import org.ex.world.Position;

public interface Entity {

	Action getInscription(ExecutionContext context);

	void inscribe(ExecutionContext context, Action action);

	void move(Position position);

	Position getPosition();

}
