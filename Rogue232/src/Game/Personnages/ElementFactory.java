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
			return PersonnageFactory.createHero(postion);
		case "a":
			return PersonnageFactory.createMonster(postion);
		case "]":
			return new Chest(postion);
		default:
			throw new IllegalArgumentException("Character not valid");
		}
	}
}
