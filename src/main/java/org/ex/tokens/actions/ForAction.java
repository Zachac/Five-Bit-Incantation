package org.ex.tokens.actions;

import org.ex.parser.ExecutionContext;
import org.ex.tokens.search.Search;
import org.ex.world.entities.Entity;

public class ForAction implements Action {

	public Search search;
	public Action action;
	
	public ForAction(Search search, Action action) {
		super();
		this.search = search;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		if (search != null) {
			for (Entity e : search.getEntities()) {
				context.push(e);
				action.execute(context);
			}
		}
	}
	
}
