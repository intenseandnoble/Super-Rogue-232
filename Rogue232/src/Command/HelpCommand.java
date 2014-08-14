package Command;

import Game.Game;
import Game.Character.GameCharacter;

public class HelpCommand extends Command{
	
	public HelpCommand(Game g) {
		super(g);
	}

	@Override
	public void execute() {
		GameCharacter.notify("Be a man");
	}

}
