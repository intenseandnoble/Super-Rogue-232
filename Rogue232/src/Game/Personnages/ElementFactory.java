package Game.Personnages;

import Game.Items.*;
import Game.Personnages.*;
import Game.Coord;

public class ElementFactory {
	
	protected ElementFactory() {
	}

	public static Element create(String s, Coord postion) {
		switch (s) {
		case "@":
			return new Hero(postion);
		case "a":
			return new Monsters(postion);
		case "]":
			return new Chest(postion);
		default:
			throw new IllegalArgumentException("Character not valid");
		}
	}
}
