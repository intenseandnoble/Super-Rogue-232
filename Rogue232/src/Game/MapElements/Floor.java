package Game.MapElements;

import Game.Coord;
import Game.Character.Element;

public class Floor extends MapElement {
	private Element element;
	private boolean occupied;

	public Floor() {
		element = null;
		symbol = '.';
		position = null;
		occupied = false;
	}

	public Floor(Coord aPosition) {
		element = null;
		symbol = '.';
		position = aPosition;
		occupied = false;
	}

	public Floor(Coord aPosition, Element aElement) {
		element = aElement;
		symbol = '.';
		position = aPosition;
		occupied = true;
	}

	@Override
	public boolean isCollidable() {
		return occupied;
	}

	@Override
	public Element getElement() {
		return element;
	}

	@Override
	public boolean content() {
		return (element!=null);
	}

	public void putElement(Element aElement) {
		if (!occupied) {
			element = aElement;
			occupied = true;
		}
	}

	public void removeElement() {
		element = null;
		occupied = false;
	}

	public boolean isMonster() {
		if (element != null)
			element.isMonster();
		return false;
	}

	public char getSymbol() {
		if (element == null)
			return '.';
		return element.getSymbol();
	}
}
