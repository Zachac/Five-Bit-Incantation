package org.ex.incantation.tokens.actions;

import org.ex.incantation.execution.ExecutionContext;
import org.ex.incantation.tokens.search.Search;
import org.ex.incantation.world.entities.Entity;

public class ForAction implements Action {

	public final Search search;
	public final Action action;
	
	public ForAction(Search search, Action action) {
		super();
		this.search = search;
		this.action = action;
	}

	public void execute(ExecutionContext context) {
		if (search != null) {
			for (Entity e : search.getEntities(context)) {
				context.push(e);
				action.execute(context);
			}
		}
	}
	
}
