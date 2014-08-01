package Game.MapElements;

import Game.Coord;
import Game.Character.Element;
import Game.Items.Key;
import Game.Items.KeyFactory;
import Game.Items.KeyGenerator;

public class Door extends MapElement {

	private Key key;
	private String doorState;
	private Element element;

	// Constructor
	
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

	@Override
	public Key getKey() {
		return key;
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
	public void open(Key aKey) {
		if (doorState.equals("close")) {
			if (aKey.getNumber() == key.getNumber() || key.isNull()) {
				symbol = '/';
				doorState = "open";
			}
		}
	}

	@Override
	public boolean isMonster() {
		return false;
	}

	@Override
	public boolean isCollidable() {
		return (symbol == '+');
	}

	@Override
	public boolean content() {
		return (element!=null);
	}

	@Override
	public void putElement(Element aElement) {
		element = aElement;
	}

	@Override
	public void removeElement() {
		element = null;
	}
	
	@Override
	public boolean hasKey(){
		return !key.isNull();
	}
}
