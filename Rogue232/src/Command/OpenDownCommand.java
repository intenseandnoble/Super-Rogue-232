package Command;

import Game.Coord;
import Game.Game;

public class OpenDownCommand extends Command{
	
	public OpenDownCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().open(game.getWorld(), new Coord(0, 1), game.getIm());
		
	}

}
