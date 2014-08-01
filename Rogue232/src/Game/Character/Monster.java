package Game.Character;

import java.util.Random;

import Game.Coord;
import Game.*;

public class Monster extends GameCharacter {

	public Monster(Coord pos, char symbol, int lifepts, int atk, int def) {
		super(pos, symbol, lifepts, atk, def);
	}

	@Override
	// add artificial intelligence
	public void move(World world, Coord coord) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(4);
		if (randomInt == 0) {
		}
	}

	public boolean isMonster() {
		return true;
	};
}
