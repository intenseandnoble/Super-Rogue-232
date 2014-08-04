package Game;

import Game.Character.GameCharacter;
import Game.Character.Hero;

public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	private GameCharacter hero;

	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;
		world = new World(file);
		hero = new Hero(new Coord(2, 2));
		Coord monsterCoord = new Coord(2, 1);

		if(world.getWidth() < 20)
			view = new View(20, world.getHeight());
		else
			view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);
		GameCharacter.notify("- Welcome in the world of SuperRogue232 -");

	}

	public void mainLoop() {
		// game loop
		while (running) {
			updateDisplay();
			command = im.getInput();
			executeCommand();
		}
		System.exit(0);// ferme fenêtre
	}

	private void executeCommand() {
		switch (command.toLowerCase()) {
		case "up":
			hero.move(world, new Coord(0, -1));
			if (hero.isDead())
				running = false;
			break;
		case "down":
			hero.move(world, new Coord(0, 1));
			if (hero.isDead())
				running = false;
			break;
		case "left":
			hero.move(world, new Coord(-1, 0));
			if (hero.isDead())
				running = false;
			break;
		case "right":
			hero.move(world, new Coord(1, 0));
			if (hero.isDead())
				running = false;
			break;
		case "open up":
			hero.open(world, new Coord(0, -1), im);
			break;
		case "open down":
			hero.open(world, new Coord(0, 1), im);
			break;
		case "open left":
			hero.open(world, new Coord(-1, 0), im);
			break;
		case "open right":
			hero.open(world, new Coord(1, 0), im);
			break;
		case "bag" :
			((Hero)hero).getBag().printBag();
			break;
		case "exit":
			System.exit(0);
			break;
		case "help":
			break;// TODO: ecrire le help

		default:
			break;
		}
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
