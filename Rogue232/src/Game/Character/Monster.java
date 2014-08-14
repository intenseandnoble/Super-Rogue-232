package Game.Character;

import java.util.Random;

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

	@Override
	public boolean isMonster() {
		return true;
	}

	@Override
	public void open(World world, Coord coord, InputManager im) {
		
	}
}
