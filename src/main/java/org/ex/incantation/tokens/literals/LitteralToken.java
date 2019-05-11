package org.ex.incantation.tokens.literals;

import org.ex.incantation.tokens.Token;

public enum LitteralToken implements Token {

	ONE("1"),
	ZERO("0"),
	INSTANTIATE,
	MOVE,
	EXISTS,
	INVERT,
	ID,
	TOUCHED,
	OWNED,
	CLOSEST,
	NEAR,
	INSIDE,
	SELF,
	HUMANOID,
	BURST,
	BALL,
	FIRE,
	WATER,
	AIR,
	EARTH,
	IF,
	WHILE,
	FOR,
	AFOREMENTIONED,
	IDENTIFY,
	TRUE,
	FALSE,
	SIMULTANEOUSLY,
	EXECUTE,
	INSCRIBE;

	public final String value;

	private LitteralToken(String value) {
		this.value = value;
	}
	
	private LitteralToken() {
		this.value = this.toString();
	}
}
