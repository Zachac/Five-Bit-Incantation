package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.literals.NumberValue;
import org.ex.incantation.tokens.search.Search;

public class InstantiateAction implements Action {

	public final NumberValue number;
	public final Search search;

	public InstantiateAction(NumberValue number, Search search) {
		super();
		this.number = number;
		this.search = search;
	}

	public void execute(ExecutionContext context) {
		context.getWorld().instantiate(number.value, search);
	}
}
