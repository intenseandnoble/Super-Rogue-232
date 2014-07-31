package Game.MapElements;

import Game.Coord;
import Game.Items.Key;
import Game.Items.KeyFactory;
import Game.Items.KeyGenerator;
import Game.Personnages.Element;

public class Door extends MapElement implements InteractiveMapElement {

	private Key key;
	private String doorState;
	private Element element;

	public Door(boolean isOpen) {
		position = null;
		key = KeyFactory.getKey("", 0);
		if (isOpen) {
			symbol = '/';
			doorState = "open";
		} else {
			symbol = '+';
			doorState = "close";
		}
	}

	public Door(Coord aPosition, Boolean isOpen, boolean hasKey) {
		position = aPosition;
		if (isOpen) {
			symbol = '/';
			doorState = "open";
		} else {
			symbol = '+';
			doorState = "close";
		}
		if (hasKey)
			key = KeyFactory.getKey("key", KeyGenerator.getKeyNumber());
		else {
			key = KeyFactory.getKey("", 0);
		}
	}

	public Key getKey() {
		return key;
	}

	public String getDoorState() {
		return doorState;
	}

	public void open(Key aKey) {
		if (doorState.equals("close")) {
			if (aKey.getNumber() == key.getNumber() || key.isNull()) {
				symbol = '/';
				doorState = "open";
			}
		}
	}

	public void open() {
		if (doorState.equals("close")) {
			symbol = '/';
			doorState = "open";
		}
	}

	public void close() {
		if (doorState.equals("open")) {
			symbol = '+';
			doorState = "close";
		}
	}

	public Door getDoor(Coord coord) {
		return this;
	}

	public boolean isOpenable() {
		return symbol == '+';
	}

	@Override
	public boolean isMonster() {
		return false;
	}

	@Override
	public boolean isCollidable() {
		if (symbol == '+')
			return true;
		else
			return false;
	}

	@Override
	public Element contient() {
		if (element != null)
			return element;
		else
			return null;
	}

	@Override
	public boolean putElement(Element aElement) {
		element = aElement;
		return true;
	}

	@Override
	public void removeElement() {
		element = null;
	}
}
