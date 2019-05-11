package org.ex.incantation.tokens.tests;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.identifier.Identifier;
import org.ex.incantation.tokens.search.Search;

public class ExistsTest implements Test {

	public final Search search;
	public final Identifier identifier;
	
	public ExistsTest(Search search) {
		super();
		this.search = search;
		this.identifier = null;
	}
	
	public ExistsTest(Identifier identifier) {
		super();
		this.identifier = identifier;
		this.search = null;
	}

	public boolean value(ExecutionContext context) {
		return identifier.value(context) != null;
	}
	
}
