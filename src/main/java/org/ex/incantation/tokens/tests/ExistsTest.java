package org.ex.incantation.tokens.tests;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.search.Search;

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
