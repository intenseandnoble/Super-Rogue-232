package Command;

import Game.Coord;
import Game.Game;
import Game.Character.GameCharacter;
import Game.Character.Hero;

public class BagCommand extends Command{
	
	public BagCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		if(!((Hero)game.getHero()).getBag().isEmpty())
			((Hero)game.getHero()).getBag().printBag();
		else GameCharacter.notify("There's nothing in your bag.");
	}

}
