package org.ex.incantation.tokens.elements;

import org.ex.incantation.utils.ArrayUtils;

public class MixedElement implements Element {

	static final Element[] ELEMENTS = org.ex.incantation.utils.Reflections.get()
			.getSubTypesOf(Element.class)
			.toArray(new Element[0]);
	
	private boolean calculatedElements = false;
	private int elements;
	
	Element element1;
	Element element2;

	@Override
	public boolean matches(Element value) {
		if (!(value instanceof MixedElement)) {
			return (getElements() & ArrayUtils.find(ELEMENTS, element1)) != 0;
		}
		
		return (this.getElements() | ((MixedElement) value).getElements()) <= this.getElements();
	}

	private int getElements() {
		if (calculatedElements) {
			return elements;
		}
		
		elements = 0;
		
		if (element1 instanceof MixedElement) {
			elements |= ((MixedElement) element1).getElements();
		} else {
			elements |= 1 << ArrayUtils.find(ELEMENTS, element1);
		}
		
		if (element2 instanceof MixedElement) {
			elements |= ((MixedElement) element2).getElements();
		} else {
			elements |= 1 << ArrayUtils.find(ELEMENTS, element2);
		}
		
		return elements;
	}
}
