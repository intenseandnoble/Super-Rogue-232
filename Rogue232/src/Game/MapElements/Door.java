package Game.MapElements;

import Game.Personnages.Element;

public class Door extends MapElement {
	private boolean isOpen;
	private Element element;
	private boolean occupied;

	public Door(boolean openClose) {
		isOpen = openClose;
		element = null;
		occupied = false;

	}

	@Override
	public char getSymbol() {
		if (contient() != null) {
			return (contient()).getSymbol();
		} else if (!isOpen) {
			return '+';
		}
		return '/';
	}

	@Override
	public boolean isCollidable() {
		if (occupied) {
			return true;
		}
		return false;
	}

	protected Element contient() {
		if (element != null)
			return element;
		else
			return null;
	}

	public boolean putElement(Element elemnt) {
		if (!occupied) {
			element = elemnt;
			occupied = true;
			return true; // SUCCESS!!
		}
		return false; // FAIL D:
	}	
}
