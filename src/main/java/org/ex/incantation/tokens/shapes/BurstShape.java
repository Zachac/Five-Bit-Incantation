package org.ex.incantation.tokens.shapes;

public class BurstShape implements Shape {

	@Override
	public boolean matches(Shape value) {
		return value instanceof BurstShape;
	}
}
