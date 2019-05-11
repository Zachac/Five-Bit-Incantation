package org.ex.incantation.tokens.types;

import org.ex.incantation.tokens.elements.Element;
import org.ex.incantation.tokens.shapes.Shape;
import org.ex.incantation.utils.Matcher;
import org.ex.incantation.world.entities.Entity;

public class Type implements Matcher<Entity> {

	public final Element element;
	public final Shape shape;
	
	public Type(Element element, Shape shape) {
		super();
		this.element = element;
		this.shape = shape;
	}

	@Override
	public boolean matches(Entity e) {
		return this.element.matches(e.element()) && this.shape.matches(e.shape());
	}

}
