package org.ex.tokens.tests;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.identifier.Identifier;
import org.ex.tokens.search.Search;

public class ExistsTest implements Test {

	public Search search;
	public Identifier identifier;

	public ExistsTest(Search search) {
		super();
		this.search = search;
	}
	
	public ExistsTest(Identifier identifier) {
		super();
		this.identifier = identifier;
	}

	public boolean value(ExecutionContext context) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
