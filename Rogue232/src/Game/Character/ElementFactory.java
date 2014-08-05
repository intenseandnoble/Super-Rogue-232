package Game.Character;

import Game.Coord;
import Game.Items.Chest;

public class ElementFactory {
	private static String[] monsterArray = { "a", "b", "c", "d", "e", "f", "g",
			"h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
			"u", "v", "w", "x", "y", "z" };

	protected ElementFactory() {
	}

	public static Element create(String s, Coord postion) {
		if (compareStringMonster(s)) {
			return GameCharacterFactory.createMonster(postion, s.charAt(0));
		}
		switch (s) {
		case "@":
			return GameCharacterFactory.createHero(postion);
		case "]":
			return new Chest(postion);
		default:
			throw new IllegalArgumentException("Character not valid");
		}
	}

	private static boolean compareStringMonster(String s) {
		for (int i = 0; i < monsterArray.length; i++) {
			if (monsterArray[i].equals(s)) {
				return true;
			}
		}
		return false;
	}
}