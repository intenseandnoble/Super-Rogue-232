package Command;

import Game.Coord;
import Game.Game;

public class OpenLeftCommand extends Command{
	
	public OpenLeftCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().open(game.getWorld(), new Coord(-1, 0), game.getIm());		
	}

}
