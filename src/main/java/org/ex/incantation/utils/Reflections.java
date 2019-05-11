package org.ex.incantation.utils;

public class Reflections {

	private static org.reflections.Reflections reflections;

	public static org.reflections.Reflections get() {
		if (reflections == null) {
			 reflections = new org.reflections.Reflections("org.ex.incantation");
		}
		
		return reflections;
	}
}
