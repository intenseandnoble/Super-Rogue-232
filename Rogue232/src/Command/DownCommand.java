package Command;

import Game.Coord;
import Game.Game;

public class DownCommand extends Command{
	
	public DownCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().move(game.getWorld(), new Coord(0, 1));
		
	}

}
