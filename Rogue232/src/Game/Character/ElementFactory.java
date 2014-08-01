package Game.Character;

import Game.Coord;
import Game.Items.Chest;

public class ElementFactory {

	protected ElementFactory() {
	}

	public static Element create(String s, Coord postion) {
		switch (s) {
		case "@":
			return GameCharacterFactory.createHero(postion);
		case "a":
			return GameCharacterFactory.createMonster(postion);
		case "]":
			return new Chest(postion);
		default:
			throw new IllegalArgumentException("Character not valid");
		}
	}
}