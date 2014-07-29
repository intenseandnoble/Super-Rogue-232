package Game.MapElements;

import Game.Coord;
import Game.Items.*;
import Game.Personnages.*;

public class Door extends MapElement {

	private Key key;
	private String doorState;
	
	public Door(boolean isOpen){
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

	public void Open(Key aKey) {
		if (doorState.equals("close")) {
			if (aKey.getNumber() == key.getNumber() || key.isNull()) {
				symbol = '/';
				doorState = "open";
			}
		}
	}

	public void Close() {
		if (doorState.equals("open")) {
			symbol = '+';
			doorState = "close";
		}
	}

}
