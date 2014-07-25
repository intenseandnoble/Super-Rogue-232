package Game;

import java.awt.Container;
import java.util.HashMap;

import Game.Items.*;


public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	private HashMap<Character,Character> openTo;
	private Personnage hero;
	private HashMap<Coord, Personnage> monsters;
	private HashMap<Coord, Chest> coffres;

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
		//private Chest coffre = new Chest( new Shield("Dacamole épique de l'Enfer", 40, 10));
		
	}

	public void mainLoop() {

		// game loop
		while (running) {

			updateDisplay();
			command = im.getInput();
			executeCommand();
		}
		System.exit(0);//ferme fenêtre
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

		} else if (!world.isCollidable(newPosPersonnage)) {
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
		Personnage.notifyChange("The hero and " + monster.getSymbol() + " fight!");
		hero.attackChar(monster);
		monster.attackChar(hero);
		if (hero.isDead()){
			Personnage.notifyChange("Hero dead");
			gameOver();
		}
		else if (monster.isDead()){
			Personnage.notifyChange("Monster dead");
			removeMonster(monster.getPosition());
		}
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
		if (world.isOpenable(newPos)) {
			System.out.println(world.getChar(posCharacter));
			world.setChar(newPos, openTo.get(world.getChar(newPos)).charValue());
			Personnage.notifyChange("It's opened");
			
			if (world.getChar(newPos) == '[') {
				Item anItem = coffres.get(newPos).getBonus();
				String nameItem = anItem.getNom();
				Personnage.notifyChange("You found " + nameItem);
//				hero.receivesShield(anItem);
			}
			
		}
	}

	private boolean isMonster(Coord coord) {
		boolean isMonster = monsters.containsKey(coord);
		return isMonster;

	}

	private void updateDisplay() {
		ge.updateDisplay(world, monsters, hero);
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
