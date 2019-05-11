package org.ex.incantation.world;

import org.ex.incantation.tokens.search.Search;
import org.ex.incantation.tokens.types.Type;
import org.ex.incantation.world.entities.Entity;

public interface World {

	/**
	 * Find entity registered to this id value
	 * @param value the id of the entity to find
	 * @return the entity or null if they weren't found.
	 */
	Entity find(int value);

	/**
	 * Find n closest entities to this position that match the given type.
	 * @param position the position to search from.
	 * @param type the type of entity to match against.
	 * @param n the amount of entities to return.
	 * @return an array containing 0 to n entities sorted by their distance to the given position.
	 */
	Entity[] findClosest(Position position, Type type, int n);

	/**
	 * Find n closest entities to this position.
	 * @param position the position to search from.
	 * @param n the amount of entities to return.
	 * @return an array containing 0 to n entities sorted by their distance to the given position.
	 */
	Entity[] findClosest(Position position, int i);

	/**
	 * Instantiate n entities that matches the given criteria of the search.
	 * @param n 
	 * @param search
	 */
	void instantiate(int n, Search search);

}
