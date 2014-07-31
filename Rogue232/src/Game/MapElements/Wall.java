package Game.MapElements;

import Game.Coord;
import Game.Personnages.Element;

public class Wall extends MapElement {

	public Wall(String wallDirection) {
		if (wallDirection.toLowerCase().equals("horizontal")) {
			symbol = '-';
		} else {
			symbol = '|';
		}
		position = null;
	}

	public Wall(String wallDirection, Coord aPosition) {
		if (wallDirection.toLowerCase().equals("horizontal")) {
			symbol = '-';
		} else {
			symbol = '|';
		}
		position = aPosition;
	}

	@Override
	public boolean isCollidable() {
		return true;
	}

	@Override
	public boolean isMonster() {
		return false;
	}

	@Override
	public void removeElement() {
	}

	@Override
	public Element content() {
		return null;
	}

	@Override
	public void putElement(Element content) {
	}
}
