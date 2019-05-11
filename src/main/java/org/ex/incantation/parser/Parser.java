package org.ex.incantation.parser;

import static org.ex.incantation.tokens.literals.LitteralToken.AFOREMENTIONED;
import static org.ex.incantation.tokens.literals.LitteralToken.AIR;
import static org.ex.incantation.tokens.literals.LitteralToken.BALL;
import static org.ex.incantation.tokens.literals.LitteralToken.BURST;
import static org.ex.incantation.tokens.literals.LitteralToken.CLOSEST;
import static org.ex.incantation.tokens.literals.LitteralToken.EARTH;
import static org.ex.incantation.tokens.literals.LitteralToken.EXECUTE;
import static org.ex.incantation.tokens.literals.LitteralToken.EXISTS;
import static org.ex.incantation.tokens.literals.LitteralToken.FALSE;
import static org.ex.incantation.tokens.literals.LitteralToken.FIRE;
import static org.ex.incantation.tokens.literals.LitteralToken.FOR;
import static org.ex.incantation.tokens.literals.LitteralToken.HUMANOID;
import static org.ex.incantation.tokens.literals.LitteralToken.ID;
import static org.ex.incantation.tokens.literals.LitteralToken.IDENTIFY;
import static org.ex.incantation.tokens.literals.LitteralToken.IF;
import static org.ex.incantation.tokens.literals.LitteralToken.INSCRIBE;
import static org.ex.incantation.tokens.literals.LitteralToken.INSIDE;
import static org.ex.incantation.tokens.literals.LitteralToken.INSTANTIATE;
import static org.ex.incantation.tokens.literals.LitteralToken.INVERT;
import static org.ex.incantation.tokens.literals.LitteralToken.MOVE;
import static org.ex.incantation.tokens.literals.LitteralToken.NEAR;
import static org.ex.incantation.tokens.literals.LitteralToken.SELF;
import static org.ex.incantation.tokens.literals.LitteralToken.SIMULTANEOUSLY;
import static org.ex.incantation.tokens.literals.LitteralToken.TOUCHED;
import static org.ex.incantation.tokens.literals.LitteralToken.TRUE;
import static org.ex.incantation.tokens.literals.LitteralToken.WATER;
import static org.ex.incantation.tokens.literals.LitteralToken.WHILE;

import org.ex.incantation.exception.UnexpectedTokenException;
import org.ex.incantation.tokens.Token;
import org.ex.incantation.tokens.actions.Action;
import org.ex.incantation.tokens.actions.AdditionallyAction;
import org.ex.incantation.tokens.actions.ExecuteAction;
import org.ex.incantation.tokens.actions.ForAction;
import org.ex.incantation.tokens.actions.IdentifyAction;
import org.ex.incantation.tokens.actions.IfAction;
import org.ex.incantation.tokens.actions.InscribeAction;
import org.ex.incantation.tokens.actions.InstantiateAction;
import org.ex.incantation.tokens.actions.MoveAction;
import org.ex.incantation.tokens.actions.WhileAction;
import org.ex.incantation.tokens.elements.AirElement;
import org.ex.incantation.tokens.elements.AnyElement;
import org.ex.incantation.tokens.elements.EarthElement;
import org.ex.incantation.tokens.elements.Element;
import org.ex.incantation.tokens.elements.FireElement;
import org.ex.incantation.tokens.elements.WaterElement;
import org.ex.incantation.tokens.identifier.AforementionedIdentifier;
import org.ex.incantation.tokens.identifier.IdIdentifier;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.identifier.SelfIdentifier;
import org.ex.incantation.tokens.literals.NumberValue;
import org.ex.incantation.tokens.location.ClosestLocation;
import org.ex.incantation.tokens.location.InsideLocation;
import org.ex.incantation.tokens.location.Location;
import org.ex.incantation.tokens.location.NearLocation;
import org.ex.incantation.tokens.location.TouchedLocation;
import org.ex.incantation.tokens.search.Search;
import org.ex.incantation.tokens.shapes.BallShape;
import org.ex.incantation.tokens.shapes.BurstShape;
import org.ex.incantation.tokens.shapes.HumanoidShape;
import org.ex.incantation.tokens.shapes.Shape;
import org.ex.incantation.tokens.tests.ExistsTest;
import org.ex.incantation.tokens.tests.FalseTest;
import org.ex.incantation.tokens.tests.InvertTest;
import org.ex.incantation.tokens.tests.Test;
import org.ex.incantation.tokens.tests.TrueTest;
import org.ex.incantation.tokens.types.Type;

public class Parser {

	
	public static Action recognizeAction(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		Action result = null;
		
		if (t == IF ) {
			result = new IfAction(recognizeTest(input), recognizeAction(input));
		} else if (t == WHILE) {
			result = new WhileAction(recognizeTest(input), recognizeAction(input));
		} else if (t == FOR) {
			result = new ForAction(recognizeSearch(input), recognizeAction(input));
		} else if (t == INSTANTIATE) {
			result = new InstantiateAction(recognizeNumber(input), recognizeSearch(input));
		} else if (t == IDENTIFY) {
			result = new IdentifyAction(recognizeIdentifier(input));
		} else if (t == MOVE) {
			result = new MoveAction(recognizeIdentifier(input), recognizeLocation(input));
		} else if (t == EXECUTE) {
			result = new ExecuteAction(recognizeIdentifier(input));
		} else if (t == INSCRIBE) {
			result = new InscribeAction(recognizeIdentifier(input), recognizeAction(input));
		} else if (t == SIMULTANEOUSLY) {
			return new AdditionallyAction(recognizeAction(input), recognizeAction(input));
		} else {
			throw new UnexpectedTokenException(t);
		}
		
		return result;
	}

	private static Location recognizeLocation(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		
		if (t == TOUCHED) {
			return new TouchedLocation();
		} else if (t == CLOSEST) {
			return new ClosestLocation();
		} else if (t == NEAR) {
			return new NearLocation(recognizeIdentifier(input));
		} else if (t == INSIDE) {
			return new InsideLocation(recognizeIdentifier(input));
		} else {
			throw new UnexpectedTokenException(t);
		}
	}

	private static Identifier recognizeIdentifier(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		
		if (t == ID) {
			return new IdIdentifier(recognizeNumber(input));
		} else if (t == AFOREMENTIONED) {
			return new AforementionedIdentifier(recognizeNumber(input));
		} else if (t == SELF) {
			return new SelfIdentifier();
		} else {
			throw new UnexpectedTokenException(t);
		}
	}

	private static NumberValue recognizeNumber(ReadAheadTokenizer input) throws UnexpectedTokenException {
		if (input.peek() instanceof NumberValue) {
			return (NumberValue) input.next();
		}
		
		return new NumberValue(0);
	}

	private static Search recognizeSearch(ReadAheadTokenizer input) throws UnexpectedTokenException {
		return new Search(recognizeType(input), recognizeLocation(input));
	}

	private static Type recognizeType(ReadAheadTokenizer input) throws UnexpectedTokenException {
		return new Type(recognizeElement(input), recognizeShape(input));
	}

	private static Shape recognizeShape(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		
		if (t == BURST) {
			return new BurstShape();
		} else if (t == BALL) {
			return new BallShape();
		} else if (t == HUMANOID) {
			return new HumanoidShape();
		} else {
			throw new UnexpectedTokenException(t);
		}
	}

	private static Element recognizeElement(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.peek();
		
		if (t == FIRE) {
			input.next();
			return new FireElement();
		} else if (t == WATER) {
			input.next();
			return new WaterElement();
		} else if (t == AIR) {
			input.next();
			return new AirElement();
		} else if (t == EARTH) {
			input.next();
			return new EarthElement();
		} else {
			return new AnyElement();
		}
	}

	private static Test recognizeTest(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		
		if (t == EXISTS) {
			if (peekIdentifier(input)) {
				return new ExistsTest(recognizeIdentifier(input));
			}
			
			return new ExistsTest(recognizeIdentifier(input));
		} else if (t == INVERT) {
			return new InvertTest(recognizeTest(input));
		} else if (t == TRUE) {
			return new TrueTest();
		} else if (t == FALSE) {
			return new FalseTest();
		} else {
			throw new UnexpectedTokenException(t);
		}
	}
	
	private static boolean peekIdentifier(ReadAheadTokenizer input) {
		Token t = input.peek();
		return t == ID || t == AFOREMENTIONED || t == SELF;
	}
	
}
