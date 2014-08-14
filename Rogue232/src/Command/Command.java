package Command;

import Game.Game;

public abstract class Command {
	
	Game game;
	
	public Command (Game g) {
		game =g;
	}
	
	public abstract void execute();
	
}
