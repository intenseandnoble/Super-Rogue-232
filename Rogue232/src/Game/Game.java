package Game;

import Game.Personnages.Hero;
import Game.Personnages.Personnage;

public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	// private HashMap<Character,Character> openTo;
	private Personnage hero;

	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;
		world = new World(file);
		hero = new Hero(new Coord(2, 2));
		Coord monsterCoord = new Coord(2, 1);
		// world.addPersonnage(monsterCoord,
		// PersonnageFactory.createMonster(monsterCoord));
		// world.addChest(new Chest(new Coord(2, 3)));
		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);
		// private Chest coffre = new Chest( new
		// Shield("Dacamole épique de l'Enfer", 40, 10));

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

	public Personnage getHero() {
		return hero;
	}

	public View getView() {
		return view;
	}
}
