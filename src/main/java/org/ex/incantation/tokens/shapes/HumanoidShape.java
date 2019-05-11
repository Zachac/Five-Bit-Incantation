package org.ex.incantation.tokens.shapes;

public class HumanoidShape implements Shape {

	@Override
	public boolean matches(Shape value) {
		return value instanceof HumanoidShape;
	}

}
