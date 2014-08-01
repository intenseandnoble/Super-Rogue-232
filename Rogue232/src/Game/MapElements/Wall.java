package Game.MapElements;

import Game.Coord;
import Game.Character.Element;

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
	public boolean content() {
		return false;
	}

	@Override
	public void putElement(Element content) {
	}
}
