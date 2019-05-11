package org.ex.incantation.world.entities;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.actions.Action;
import org.ex.incantation.tokens.elements.Element;
import org.ex.incantation.tokens.shapes.Shape;
import org.ex.incantation.world.Position;

public interface Entity {

	Action getInscription(ExecutionContext context);

	void inscribe(ExecutionContext context, Action action);

	void move(Position position);

	Position getPosition();

	void displayInfo(Entity value);

	/**
	 * Find any Entities aliased by this Number or null if no aliases match.
	 */
	Entity resolveEntity(int value);

	Entity[] contents();

	/**
	 * Get the element this entity is categorized in.
	 */
	Element element();

	/**
	 * Get the shape this entity is categorized in.
	 */
	Shape shape();

}
