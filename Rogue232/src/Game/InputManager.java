package Game;

import java.util.HashMap;

import Command.*;


public class InputManager {

	private View view;
	private Game game;
	
	private HashMap<String, Command> commandList;

	public InputManager(View view, Game g) {
		this.view = view;
		this.game = g;
		commandList = new HashMap<String, Command>();
		commandList.put("up", new UpCommand(game));
		commandList.put("down", new DownCommand(game));
		commandList.put("left", new LeftCommand(game));
		commandList.put("right", new RightCommand(game));
		commandList.put("open up", new OpenUpCommand(game));
		commandList.put("open down", new OpenDownCommand(game));
		commandList.put("open left", new OpenLeftCommand(game));
		commandList.put("open right", new OpenRightCommand(game));
		commandList.put("help", new HelpCommand(game));
		commandList.put("exit", new ExitCommand(game));
		commandList.put("bag", new BagCommand(game));
	}

	public Command getInput() {
		String s = view.getCommand().toLowerCase();
		Command c = commandList.get(s);
		if (c == null){
			return commandList.get("help");
		}
		return c;
	}

	public String getRawInput() {
	
		return view.getCommand().toLowerCase();

	}

}
