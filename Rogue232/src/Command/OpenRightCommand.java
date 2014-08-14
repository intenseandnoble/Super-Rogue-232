package Command;

import Game.Coord;
import Game.Game;

public class OpenRightCommand extends Command{
	
	public OpenRightCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().open(game.getWorld(), new Coord(1, 0), game.getIm());		
	}

}
