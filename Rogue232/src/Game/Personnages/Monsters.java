package Game.Personnages;

import java.util.Random;

import Game.Coord;
import Game.World;

public class Monsters extends Personnage {

	public Monsters(Coord coord) {
		super(coord);
	}
	
	@Override
	// add artificial intelligence
	public void move(World world, Coord coord) {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(4);
		if( randomInt == 0){ 
	}
	}
}
