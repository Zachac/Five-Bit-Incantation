package org.ex.tokens.types;

import org.ex.tokens.elements.Element;
import org.ex.tokens.shapes.Shape;

public class ShapeType extends Type {

	Element element;
	Shape shape;
	
	public ShapeType(Element element, Shape shape) {
		super();
		this.element = element;
		this.shape = shape;
	}
	
}
