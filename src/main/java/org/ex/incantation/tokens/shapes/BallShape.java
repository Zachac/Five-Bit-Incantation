package org.ex.incantation.tokens.shapes;

public class BallShape implements Shape {

	@Override
	public boolean matches(Shape value) {
		return value instanceof BallShape;
	}
}
