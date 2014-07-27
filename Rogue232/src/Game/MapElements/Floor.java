package Game.MapElements;

import Game.Personnages.Element;

public class Floor extends MapElement {
	private Element element;
	private boolean occupied;

	public Floor() {
		element = null;
	}

	@Override
	public char getSymbol() {
		if (contient() != null) {
			return (contient()).getSymbol();
		} else
			return '.';
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
