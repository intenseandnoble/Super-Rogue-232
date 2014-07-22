package Game;

import java.util.HashMap;

public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	private char[] Collidable = { '|', ' ', '-', '+' };
	private char[] openable = { '+' };

	private Character hero;
	private HashMap<Coord, Character> monsters;

	public Game() {

		// afficher l'information relative au jeu
		running = true;

		world = new World("maps/bigWorld.txt");
		hero = CharacterFactory.createHero(new Coord(2, 2));
		
		monsters = new HashMap<Coord, Character> ();
		monsters.put(hero.getPosition(), hero);
		Coord monsterCoord = new Coord(2,1);
		monsters.put(monsterCoord,
				CharacterFactory.createMonster(monsterCoord));

		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);

	}

	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;

		world = new World(file);
		hero = CharacterFactory.createHero(new Coord(2, 2));
		monsters = new HashMap<Coord, Character> ();
		monsters.put(hero.getPosition(), hero);
		monsters.put(new Coord(2, 1),
				CharacterFactory.createMonster(new Coord(2, 1)));
		
		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);

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
		switch (command.toLowerCase()) {
		case "up":
			move(hero.getPosition(), new Coord(0, -1));
			break;
		case "down":
			move(hero.getPosition(), new Coord(0, 1));
			break;
		case "left":
			move(hero.getPosition(), new Coord(-1, 0));
			break;
		case "right":
			move(hero.getPosition(), new Coord(1, 0));
			break;
		case "open up":
			open(hero.getPosition(), new Coord(0, -1));
			break;
		case "open right":
			open(hero.getPosition(), new Coord(1, 0));
			break;
		case "open left":
			open(hero.getPosition(), new Coord(-1, 0));
			break;
		case "open down":
			open(hero.getPosition(), new Coord(0, 1));
			break;
		case "exit":
			System.exit(0);
			break;
		case "help":
			break;//TODO: ecrire le help

		default:
			break;
		}
	}

	public void move(Coord posCharacter, Coord coord) {
		// TODO: changer test pour mettre private
		Coord newPosCharacter = posCharacter.add(coord);
		if (isMonster(newPosCharacter)) {
			fight(monsters.get(posCharacter), monsters.get(newPosCharacter));

		} else if (!isCollidable(newPosCharacter)) {
			monsters.get(posCharacter).setPosition(newPosCharacter);
			Character tmpCharacter = monsters.get(posCharacter);
			monsters.remove(posCharacter);
			monsters.put(newPosCharacter, tmpCharacter);
		}

	}

	public void fight(Character hero, Character monster) {
		// 0 : personne mort, juste d�g�ts;
		// -1: hero mort, game over;
		// 1 : monster mort;
		hero.attackChar(monster);
		monster.attackChar(hero);
		if (hero.isDead())
			gameOver(); // � impl�menter
		else if (monster.isDead())
			removeMonster(monster.getPosition()); // � impl�menter
	}

	private void removeMonster(Coord coord) {
		monsters.remove(coord);

	}

	private void gameOver() {
		// TODO Auto-generated method stub

	}

	public void open(Coord posCharacter, Coord coord) {
		// fonctionne seulement pour les portes
		Coord newPos = posCharacter.add(coord);
		if (isOpenable(newPos)) {
			world.setChar(newPos, '/');
		}
	}

	private boolean isCollidable(Coord coord) {
		boolean isCollidable = false;
		char toCompare = world.getChar(coord);
		
		for (char c : Collidable) {
			if (toCompare == c)
				isCollidable = true;
		}
		return isCollidable;
	}

	private boolean isMonster(Coord coord) {
		boolean isMonster = monsters.containsKey(coord);
		return isMonster;

	}

	private boolean isOpenable(Coord coord) {
		boolean isOpenable = false;
		char toCompare = world.getChar(coord);
		for (char c : openable) {
			if (toCompare == c)
				isOpenable = true;
			}
		return isOpenable;
	}

	private void updateDisplay() {
		ge.updateDisplay(world, monsters);
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

	public Character getHero() {
		return hero;
	}

}
