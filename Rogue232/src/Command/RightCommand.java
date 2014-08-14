package Command;

import Game.Coord;
import Game.Game;

public class RightCommand extends Command{
	
	public RightCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		game.getHero().move(game.getWorld(), new Coord(1, 0));
		
	}

}
