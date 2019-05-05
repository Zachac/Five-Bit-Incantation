package org.ex.parser;

import static org.ex.tokens.literals.LitteralToken.*;

import org.ex.exception.UnexpectedTokenException;
import org.ex.tokens.Token;
import org.ex.tokens.actions.Action;
import org.ex.tokens.actions.AdditionallyAction;
import org.ex.tokens.actions.ExecuteAction;
import org.ex.tokens.actions.ForAction;
import org.ex.tokens.actions.IdentifyAction;
import org.ex.tokens.actions.IfAction;
import org.ex.tokens.actions.InscribeAction;
import org.ex.tokens.actions.InstantiateAction;
import org.ex.tokens.actions.MoveAction;
import org.ex.tokens.actions.WhileAction;
import org.ex.tokens.elements.AirElement;
import org.ex.tokens.elements.EarthElement;
import org.ex.tokens.elements.Element;
import org.ex.tokens.elements.FireElement;
import org.ex.tokens.elements.WaterElement;
import org.ex.tokens.identifier.AforementionedIdentifier;
import org.ex.tokens.identifier.IdIdentifier;
import org.ex.tokens.identifier.Identifier;
import org.ex.tokens.identifier.SelfIdentifier;
import org.ex.tokens.literals.NumberValue;
import org.ex.tokens.location.ClosestLocation;
import org.ex.tokens.location.InsideLocation;
import org.ex.tokens.location.Location;
import org.ex.tokens.location.NearLocation;
import org.ex.tokens.location.OwnedLocation;
import org.ex.tokens.location.TouchedLocation;
import org.ex.tokens.search.Search;
import org.ex.tokens.shapes.BallShape;
import org.ex.tokens.shapes.BurstShape;
import org.ex.tokens.shapes.Shape;
import org.ex.tokens.tests.ExistsTest;
import org.ex.tokens.tests.FalseTest;
import org.ex.tokens.tests.InvertTest;
import org.ex.tokens.tests.Test;
import org.ex.tokens.tests.TrueTest;
import org.ex.tokens.types.HumanoidType;
import org.ex.tokens.types.ShapeType;
import org.ex.tokens.types.Type;

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
		
		if (t == OWNED) {
			return new OwnedLocation();
		} else if (t == TOUCHED) {
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
		Element e = recognizeElement(input);
		
		Token t = input.peek();
		
		if (t == HUMANOID) {
			input.next();
			return new HumanoidType(e);
		} else {
			return new ShapeType(e, recognizeShape(input));
		}
	}

	private static Shape recognizeShape(ReadAheadTokenizer input) throws UnexpectedTokenException {
		Token t = input.next();
		
		if (t == BURST) {
			return new BurstShape();
		} else if (t == BALL) {
			return new BallShape();
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
			return null;
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
