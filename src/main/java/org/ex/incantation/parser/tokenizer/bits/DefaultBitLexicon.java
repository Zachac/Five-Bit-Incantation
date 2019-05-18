package org.ex.incantation.parser.tokenizer.bits;

import org.ex.incantation.parser.tokenizer.Lexicon;
import org.ex.incantation.tokens.Token;
import org.ex.incantation.tokens.literals.LitteralToken;

public class DefaultBitLexicon implements Lexicon<Integer> {

	@Override
	public Token translate(Integer bitState) {
		switch (bitState) {
		case 0x1: return LitteralToken.ONE;
		case 0x2: return LitteralToken.ZERO;
		case 0x3: return LitteralToken.AFOREMENTIONED;
		case 0x4: return LitteralToken.AIR;
		case 0x5: return LitteralToken.BALL;
		case 0x6: return LitteralToken.BURST;
		case 0x7: return LitteralToken.CLOSEST;
		case 0x8: return LitteralToken.EARTH;
		case 0x9: return LitteralToken.EXECUTE;
		case 0xA: return LitteralToken.EXISTS;
		case 0xB: return LitteralToken.FALSE;
		case 0xC: return LitteralToken.FIRE;
		case 0xD: return LitteralToken.FOR;
		case 0xE: return LitteralToken.HUMANOID;
		case 0xF: return LitteralToken.ID;
		case 0x10: return LitteralToken.IDENTIFY;
		case 0x11: return LitteralToken.IF;
		case 0x12: return LitteralToken.INSCRIBE;
		case 0x13: return LitteralToken.INSIDE;
		case 0x14: return LitteralToken.INSTANTIATE;
		case 0x15: return LitteralToken.INVERT;
		case 0x16: return LitteralToken.MOVE;
		case 0x17: return LitteralToken.NEAR;
		case 0x18: return LitteralToken.SELF;
		case 0x19: return LitteralToken.SIMULTANEOUSLY;
		case 0x1A: return LitteralToken.TOUCHED;
		case 0x1B: return LitteralToken.TRUE;
		case 0x1C: return LitteralToken.WATER;
		case 0x1D: return LitteralToken.WHILE;
		default: return null;
		}
	}

}
