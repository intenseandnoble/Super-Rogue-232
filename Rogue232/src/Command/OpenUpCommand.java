package Command;

import Game.Coord;
import Game.Game;

public class OpenUpCommand extends Command{
	
	public OpenUpCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().open(game.getWorld(), new Coord(0, -1), game.getIm());
		
	}

}
