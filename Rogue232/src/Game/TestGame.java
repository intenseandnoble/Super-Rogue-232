package Game;

import java.util.ArrayList;
import java.util.Arrays;

import Game.Items.Chest;
import Game.Items.Item;
import Game.Personnages.Personnage;
import junit.framework.TestCase;

public class TestGame extends TestCase {

	public void testWorldConstructor() {
		// TODO: transferer dans TestWorld quand il existera
		World world = new World("maps/smallWorld.txt");
		ArrayList<char[]> data = new ArrayList<char[]>();
		char[] array = { '|', '-', '-', '-', '|' };
		char[] array2 = { '|', '.', '.', '.', '|' };
		char[] array3 = { '|', '.', '.', '+', '|' };
		char[] array4 = { '|', '.', ']', '.', '|' };
		char[] array5 = { '|', '-', '-', '-', '|' };
		char[][] a = { array, array2, array3, array4, array5 };
		for (char[] c : a) {
			data.add(c);
		}
		ArrayList<char[]> data2 = world.getData();
		for (int i = 0; i < data.size(); ++i) {
			assertTrue(Arrays.equals(data.get(i), data2.get(i)));
		}
	}

	public void testMove() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.move(myGame.getHero().getPosition(), new Coord(-1, 0));

		myGame.move(myGame.getHero().getPosition(), new Coord(-1, 0));

		assertTrue(myGame.getHero().getPosition().equals(new Coord(1, 2)));
	}

	public void testOpen() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.open(myGame.getHero().getPosition(), new Coord(1, 0));
		assertTrue((myGame.getWorld().getCharacter(new Coord(3, 2))) == '/');
	}

	public void testHp() {
		Game myGame = new Game("maps/smallWorld.txt");
		myGame.move(myGame.getHero().getPosition(), new Coord(0, -1));
		assertEquals(100, myGame.getHero().getHp());
		myGame.move(myGame.getHero().getPosition(), new Coord(0, -1));
		assertEquals(95, myGame.getHero().getHp());
	}

	public void testFight() {
		//v�rifier lorsque le personnage meurt si on sort du jeu = arr�t jeu
		Game myGame = new Game("maps/smallWorld.txt");
		Personnage hero = new Personnage(new Coord(3,3), '@', 100, 20, 0);
		Personnage monster1 = new Personnage(new Coord(2,3), 'a', 40, 40, 0);
		Personnage monster2 = new Personnage(new Coord(3,2), 'a', 40, 40, 0);
		Personnage monster3 = new Personnage(new Coord(3,4), 'a', 40, 20, 0);
		hero.attackCharacter(monster1);
		//Le monstre doit aussi attaquer le hero.
		//hero.;
		assertTrue(!(hero.isDead())); //isalive
		hero.attackCharacter(monster2);
		assertTrue(!(hero.isDead())); //isAlwaysAlive
		hero.attackCharacter(monster3);
		assertTrue(hero.isDead()); //isDead systemOut GameOver
	}

	public void testRandomItem() {
		Chest myChest = new Chest(new Coord(0, 0));
		for (int i = 0; i < 100; i++) {
			Item myItem = myChest.getRandomItem();
			if(myItem!=null)
			System.out.println(myItem.getName());
			else System.out.println("YOLO");
			
		}
	}
}
