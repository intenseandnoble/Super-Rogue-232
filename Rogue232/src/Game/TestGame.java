package Game;

import junit.framework.TestCase;

import org.junit.Test;

import Game.Character.Hero;
import Game.Character.Monster;
import Game.Items.ArmorFactory;
import Game.Items.Key;
import Game.Items.ShieldFactory;
import Game.Items.WeaponFactory;
import Game.MapElements.Door;

public class TestGame extends TestCase {
	Game myGameSmall;
	
	public void setUp(){
		myGameSmall = new Game("maps/smallWorld.txt");
	}
	
	@Test
	public void testMoveandWall() {
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(-1, 0));
		assertTrue(myGameSmall.getHero().getPosition().equals(new Coord(1, 2)));
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(-1, 0));
		assertTrue(myGameSmall.getHero().getPosition().equals(new Coord(1, 2)));
	}

	@Test
	public void testOpenDoor() {
		myGameSmall.getHero().open(myGameSmall.getWorld(), new Coord(1, 0), myGameSmall.getIm());
		assertTrue((myGameSmall.getWorld().get(new Coord(3, 2)).getSymbol()) == '/');
	}
	
	
	// a faire
	@Test
	public void testOpenLockedDoor () {
		Door porte = (Door)myGameSmall.getWorld().get(new Coord(1,1));
		Key key = porte.lock();
		Hero hero = new Hero(new Coord(1, 2));
		hero.open(myGameSmall.getWorld(), new Coord(0, -1), myGameSmall.getIm());
		assertTrue(porte.getSymbol() == '+');
		hero.getBag().addItemBag(key);
		hero.open(myGameSmall.getWorld(), new Coord(0, -1), myGameSmall.getIm());
		assertTrue(porte.getSymbol() == '/');
	}

	@Test
	public void testHp() {
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(0, -1));
		assertEquals(90, myGameSmall.getHero().getHp());
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(0, -1));
		assertEquals(80, myGameSmall.getHero().getHp());
	}

	@Test
	public void testFight() {
		// v�rifier lorsque le personnage meurt si on sort du jeu = arr�t jeu
		Hero hero = new Hero(new Coord(3, 3));
		Monster monster1 = new Monster(new Coord(2, 3), 'a', 40, 40, 0);
		Monster monster2 = new Monster(new Coord(3, 2), 'a', 40, 40, 0);
		Monster monster3 = new Monster(new Coord(3, 4), 'a', 40, 20, 0);
		// hero.attackCharacter(monster1);
		hero.fight(monster1, myGameSmall.getWorld());
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

	public void testDestroyShield(){
		Hero hero = new Hero(new Coord(3, 3));
		Monster monster1 = new Monster(new Coord(2, 3), 'a', 40, 8, 0);
		hero.getEquipment().setEquipment(ShieldFactory.createNoobyShield());
		hero.fight(monster1, myGameSmall.getWorld());
		assertTrue(hero.getShield().getHp() == 2);
		hero.fight(monster1, myGameSmall.getWorld());
		assertTrue(hero.getShield().getHp() == 0);
	}
	
	public void testWeaponAttack () {
		
		Hero hero = new Hero(new Coord(3, 3));
		assertEquals(25, hero.afficheAtk());
		
		hero.getEquipment().setEquipment(WeaponFactory.createDummyWeapon());
		assertEquals(10, hero.afficheAtk());
		
	}

	public void testDefense () {
		
		
		Hero hero = new Hero(new Coord(3, 3));
		assertEquals(15, hero.afficheDef());
		
		hero.getEquipment().setEquipment(ShieldFactory.createDummyShield());
		assertEquals(10, hero.afficheDef());
		
		hero.getEquipment().setEquipment(ArmorFactory.createDummyArmor());
		assertEquals(5, hero.afficheDef());
		
		Monster monster1 = new Monster(new Coord(2, 3), 'a', 40, 10, 0);
		hero.getEquipment().setEquipment(ShieldFactory.createNoobyShield());
		assertEquals(10, hero.afficheDef());
		hero.fight(monster1, myGameSmall.getWorld());
		assertEquals(5, hero.afficheDef());
		
	}
	
	public void testImpossibleMove () {
		//test de deplacement vers une porte
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(1, 0));
		assertTrue(myGameSmall.getHero().getPosition().equals(new Coord(2, 2)));
		
		//test de deplacement vers une coffre
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(0, 1));
		assertTrue(myGameSmall.getHero().getPosition().equals(new Coord(2, 2)));
		
		//test de deplacement vers le monstre du map
		myGameSmall.getHero().move(myGameSmall.getWorld(), new Coord(0, -1));
		assertTrue(myGameSmall.getHero().getPosition().equals(new Coord(2, 2)));
		
	}
	
	public void testMapCreation () {
		
		for (int i =0; i < 5; ++i ) {
			assertEquals(myGameSmall.getWorld().get(new Coord(0, i)).getSymbol(), '|');
		}
		
		for (int i =0; i < 5; ++i ) {
			assertEquals(myGameSmall.getWorld().get(new Coord(4, i)).getSymbol(), '|');
		}
		
		for (int i =1; i < 4; ++i ) {
			assertEquals(myGameSmall.getWorld().get(new Coord(i, 0)).getSymbol(), '-');
		}
		
		for (int i =1; i < 4; ++i ) {
			assertEquals(myGameSmall.getWorld().get(new Coord(i, 4)).getSymbol(), '-');
		}
		
		for (int i =2; i < 4; ++i ) {
			assertEquals(myGameSmall.getWorld().get(new Coord(1, i)).getSymbol(), '.');
		}
		
		assertEquals(myGameSmall.getWorld().get(new Coord(2, 1)).getSymbol(), 'a');
		assertEquals(myGameSmall.getWorld().get(new Coord(3, 1)).getSymbol(), 'b');
		assertEquals(myGameSmall.getWorld().get(new Coord(2, 2)).getSymbol(), '@');
		assertEquals(myGameSmall.getWorld().get(new Coord(3, 2)).getSymbol(), '+');
		assertEquals(myGameSmall.getWorld().get(new Coord(2, 3)).getSymbol(), ']');

	}
	
	
	
	// Test maison pour voir si notre algorithme de hasard fonctionne correctement
//	@Test
//	public void testRandomItem() {
//		Chest myChest = new Chest(new Coord(0, 0));
//		for (int i = 0; i < 100; i++) {
//			Item myItem = myChest.getRandomItem();
//			if (myItem != null)
//				System.out.println(myItem.getName());
//			else
//				System.out.println("Nothing found.");
//
//		}
//	}
	
	public void tearDown() {
		myGameSmall = null;
	}
	
}
