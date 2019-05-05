package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.literals.NumberValue;
import org.ex.tokens.search.Search;

public class InstantiateAction implements Action {

	NumberValue number;
	Search search;

	public InstantiateAction(NumberValue number, Search search) {
		super();
		this.number = number;
		this.search = search;
	}

	public void execute(ExecutionContext context) {
		// TODO Auto-generated method stub
		search.getEntities();
	}
}
