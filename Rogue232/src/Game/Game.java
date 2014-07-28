package Game;

import java.util.HashMap;

import Game.Items.Item;
import Game.Personnages.Hero;
import Game.Personnages.Personnage;
import Game.Personnages.PersonnageFactory;


public class Game {

	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
//	private HashMap<Character,Character> openTo;
	private Personnage hero;


	public Game(String file) {
		// afficher l'information relative au jeu
		running = true;
		world = new World(file);
//		hero = PersonnageFactory.createHero(new Coord(2, 2));
		
		hero = new Hero(new Coord(2, 2));
		world.setPersonnages(new HashMap<Coord, Personnage>());
		world.addPersonnage(hero.getPosition(), hero);
		Coord monsterCoord = new Coord(2,1);
		world.addPersonnage(monsterCoord,
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
			hero.move(world ,new Coord(0, -1));
			if (hero.isDead()) running = false;
			break;
		case "down":
			hero.move(world ,new Coord(0, 1));
			if (hero.isDead()) running = false;
			break;
		case "left":
			hero.move(world ,new Coord(-1, 0));
			if (hero.isDead()) running = false;
			break;
		case "right":
			hero.move(world ,new Coord(1, 0));
			if (hero.isDead()) running = false;
			break;
		case "open up":
			hero.open(world ,new Coord(0, -1));
			break;
		case "open right":
			hero.open(world ,new Coord(1, 0));
			break;
		case "open left":
			hero.open(world ,new Coord(-1, 0));
			break;
		case "open down":
			hero.open(world ,new Coord(0, 1));
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

//	public void move(Coord posPersonnage, Coord coord) {
//		// TODO: changer test pour mettre private
//		Coord newPosPersonnage = posPersonnage.add(coord);
//		if (isMonster(newPosPersonnage)) {
//			fight(monsters.get(posPersonnage), monsters.get(newPosPersonnage));
//
//		} else if (!world.isCollidable(newPosPersonnage)) {
//			monsters.get(posPersonnage).setPosition(newPosPersonnage);
//			Personnage tmpPersonnage = monsters.get(posPersonnage);
//			monsters.remove(posPersonnage);
//			monsters.put(newPosPersonnage, tmpPersonnage);
//		}
//
//	}

//	public void fight(Personnage hero, Personnage monster) {
//		// 0 : personne mort, juste d�g�ts;
//		// -1: hero mort, game over;
//		// 1 : monster mort;
//		Personnage.notifyChange("The hero and " + monster.getSymbol() + " fight!");
//		hero.attackChar(monster);
//		monster.attackChar(hero);
//		if (hero.isDead()){
//			Personnage.notifyChange("Hero dead");
//			gameOver();
//		}
//		else if (monster.isDead()){
//			Personnage.notifyChange("Monster dead");
//			removeMonster(monster.getPosition());
//		}
//	}



	private void gameOver() {
		running = false;
		System.out.println("Game over");
	}

//	public void open(Coord posCharacter, Coord coord) {
//		// fonctionne seulement pour les portes
//		Coord newPos = posCharacter.add(coord);
//		if (world.isOpenable(newPos)) {
//			System.out.println(world.getChar(posCharacter));
//			world.setChar(newPos, openTo.get(world.getChar(newPos)).charValue());
//			Personnage.notifyChange("It's opened");
//			
//			if (world.getChar(newPos) == '[') {
//				Item anItem = world.coffres.get(newPos).getBonus();
//				String nameItem = anItem.getNom();
//				Personnage.notifyChange("You found " + nameItem);
////				hero.receivesShield(anItem);
//			}
//			
//		}
//	}

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
