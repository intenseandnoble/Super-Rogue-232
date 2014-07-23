package Game;

import java.awt.Container;
import java.util.HashMap;

public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	private char[] Collidable = { '|', ' ', '-', '+', '[', ']' };
	private char[] openable = { '+', ']' };
	private HashMap<Character,Character> openTo;

	private Personnage hero;
	private HashMap<Coord, Personnage> monsters;

	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;
		world = new World(file);
		hero = PersonnageFactory.createHero(new Coord(2, 2));
		monsters = new HashMap<Coord, Personnage> ();
		monsters.put(hero.getPosition(), hero);
		Coord monsterCoord = new Coord(2,1);
		monsters.put(monsterCoord,
				PersonnageFactory.createMonster(monsterCoord));
		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);
		openTo = new HashMap<Character, Character>();
		openTo.put(new Character(']'),new Character('['));
		openTo.put(new Character('+'),new Character('/'));
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

	public void move(Coord posPersonnage, Coord coord) {
		// TODO: changer test pour mettre private
		Coord newPosPersonnage = posPersonnage.add(coord);
		if (isMonster(newPosPersonnage)) {
			fight(monsters.get(posPersonnage), monsters.get(newPosPersonnage));

		} else if (!isCollidable(newPosPersonnage)) {
			monsters.get(posPersonnage).setPosition(newPosPersonnage);
			Personnage tmpPersonnage = monsters.get(posPersonnage);
			monsters.remove(posPersonnage);
			monsters.put(newPosPersonnage, tmpPersonnage);
		}

	}

	public void fight(Personnage hero, Personnage monster) {
		// 0 : personne mort, juste d�g�ts;
		// -1: hero mort, game over;
		// 1 : monster mort;
		hero.attackChar(monster);
		monster.attackChar(hero);
		if (hero.isDead())
			gameOver();
		else if (monster.isDead())
			removeMonster(monster.getPosition());
	}

	private void removeMonster(Coord coord) {
		monsters.remove(coord);

	}

	private void gameOver() {
		running = false;
		System.out.println("Game over");
	}

	public void open(Coord posCharacter, Coord coord) {
		// fonctionne seulement pour les portes
		Coord newPos = posCharacter.add(coord);
		if (isOpenable(newPos)) {
			System.out.println(world.getChar(posCharacter));
			world.setChar(newPos, openTo.get(world.getChar(newPos)).charValue());
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

	public Personnage getHero() {
		return hero;
	}

}
