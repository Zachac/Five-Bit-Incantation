package org.ex.incantation.utils;

import java.lang.reflect.Array;
import java.util.NoSuchElementException;

public class ArrayUtils {

	public static <V> V[] getMatching(V[] values, Matcher<V> matcher) {
		int count = 0;
		
		for (int i = 0; i < values.length; i++) {
			if (matcher.matches(values[i])) {
				count++;
			}
		}
		
		@SuppressWarnings("unchecked")
		V[] result = (V[]) Array.newInstance(values.getClass().getComponentType(), count);

		for (int i = 0, j = 0; i < values.length; i++) {
			if (matcher.matches(values[i])) {
				result[j++] = values[i];
			}
		}
		
		return result;
	}

	public static <T> int find(T[] arr, Matcher<T> e) {
		
		for (int i = 0; i < arr.length; i++) {
			if (e.matches(arr[i])) {
				return i;
			}
		}
		
		throw new NoSuchElementException();
	}
	
}
