package Game;

import Command.Command;
import Game.Character.GameCharacter;
import Game.Character.Hero;

public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private Command command;
	private GameCharacter hero;

	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;
		world = new World(file);
		hero = new Hero(new Coord(2, 2));

		if(world.getWidth() < 20)
			view = new View(20, world.getHeight());
		else
			view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view, this);
		GameCharacter.notify("- Welcome in the world of SuperRogue232 -");

	}

	public void mainLoop() {
		// game loop
		while (running) {
			updateDisplay();
			command = im.getInput();
			executeCommand();
		}

	}

	private void executeCommand() {
		command.execute();
		
		if (hero.isDead())
			running = false;
		
	}

	private void updateDisplay() {
		ge.updateDisplay(world, hero);
	}

	public World getWorld() {
		return world;
	}

	public GraphicEngine getGe() {
		return ge;
	}

	public InputManager getIm() {
		return im;
	}

	public GameCharacter getHero() {
		return hero;
	}

	public View getView() {
		return view;
	}
}
