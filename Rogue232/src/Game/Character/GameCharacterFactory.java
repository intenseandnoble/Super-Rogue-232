package Game.Character;

import Game.Coord;

public class GameCharacterFactory {

	private GameCharacterFactory() {

	}

	public static GameCharacter createHero(Coord coord) {
		return new Hero(coord);
	}

	public static GameCharacter createMonster(Coord coord) {
		return new Monster(coord, 'a', 40, 15, 0);
	}
}
