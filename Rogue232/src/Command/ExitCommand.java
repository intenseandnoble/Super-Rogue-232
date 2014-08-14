package Command;

import Game.Coord;
import Game.Game;

public class ExitCommand extends Command{
	
	public ExitCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		System.exit(0);
	}

}
