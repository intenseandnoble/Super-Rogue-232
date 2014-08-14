package Command;

import Game.Coord;
import Game.Game;

public class LeftCommand extends Command{
	
	public LeftCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().move(game.getWorld(), new Coord(-1, 0));
		
	}

}
