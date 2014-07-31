package Game;

import junit.framework.TestCase;
import Game.Items.Chest;
import Game.Items.Item;
import Game.Personnages.Hero;
import Game.Personnages.Monster;
import Game.Personnages.Personnage;

public class TestGame extends TestCase {



	public void testMove() {

		Game myGame = new Game("maps/smallWorld.txt");

		myGame.getHero().move(myGame.getWorld(), new Coord(-1, 0));

		myGame.getHero().move(myGame.getWorld(), new Coord(-1, 0));

		assertTrue(myGame.getHero().getPosition().equals(new Coord(1, 2)));
	}

	public void testOpen() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.getHero().open(myGame.getWorld(), new Coord(1, 0), myGame.getIm());
		assertTrue((myGame.getWorld().get(new Coord(3, 2)).getSymbol()) ==  '/');
	}

	public void testHp() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.getHero().move(myGame.getWorld(), new Coord(0, -1));
		assertEquals(100, myGame.getHero().getHp());
		myGame.getHero().move(myGame.getWorld(), new Coord(0, -1));
		assertEquals(90, myGame.getHero().getHp());
	}

	public void testFight() {
		// v�rifier lorsque le personnage meurt si on sort du jeu = arr�t jeu
		Game myGame = new Game("maps/smallWorld.txt");
		Hero hero = new Hero(new Coord(3, 3));
		Monster monster1 = new Monster(new Coord(2, 3), 'a', 40, 40, 0);
		Monster monster2 = new Monster(new Coord(3, 2), 'a', 40, 40, 0);
		Monster monster3 = new Monster(new Coord(3, 4), 'a', 40, 20, 0);
//		hero.attackCharacter(monster1);
		hero.fight(monster1, myGame.getWorld());
		hero.attackCharacter(monster1);
		// Le monstre doit aussi attaquer le hero.
		// hero.;
		assertTrue(!(hero.isDead())); // isalive
		hero.attackCharacter(monster2);
		assertTrue(!(hero.isDead())); // isAlwaysAlive
		hero.attackCharacter(monster3);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		monster3.attackCharacter(hero);
		
		assertTrue(hero.isDead()); // isDead systemOut GameOver
	}

	public void testRandomItem() {
		Chest myChest = new Chest(new Coord(0, 0));
		for (int i = 0; i < 100; i++) {
			Item myItem = myChest.getRandomItem();
			if (myItem != null)
				System.out.println(myItem.getName());
			else
				System.out.println("YOLO");

		}
	}
	// Ce test n'est plus necessairement necessaire.

	// public void testWorldConstructor() {
	// // TODO: transferer dans TestWorld quand il existera
	// World world = new World("maps/smallWorld.txt");
	// ArrayList<char[]> data = new ArrayList<char[]>();
	// char[] array = { '|', '-', '-', '-', '|' };
	// char[] array2 = { '|', '.', '.', '.', '|' };
	// char[] array3 = { '|', '.', '.', '+', '|' };
	// char[] array4 = { '|', '.', ']', '.', '|' };
	// char[] array5 = { '|', '-', '-', '-', '|' };
	// char[][] a = { array, array2, array3, array4, array5 };
	// for (char[] c : a) {
	// data.add(c);
	// }
	// ArrayList<ArrayList<MapElement>> data2 = world.getData();
	//
	// for (int i = 0; i < data.size(); ++i) {
	// assertTrue(Arrays.equals(data.get(i), data2.get(i)));
	// }
	// }
}
