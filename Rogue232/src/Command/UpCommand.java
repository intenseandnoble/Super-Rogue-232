package Command;

import Game.Coord;
import Game.Game;

public class UpCommand extends Command{
	
	public UpCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().move(game.getWorld(), new Coord(0, -1));
		
	}

}
