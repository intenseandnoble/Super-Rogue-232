package Game.Personnages;

import java.util.ArrayList;

import Game.Coord;
import Game.InputManager;
import Game.World;
import Game.Items.Chest;
import Game.Items.Item;
import Game.Items.KeyFactory;
import Game.MapElements.MapElement;

public class Hero extends Personnage {

	private int gold;
	private ArrayList<Item> heroBag;

	public Hero(Coord coord) {
		super(coord);
		heroBag = new ArrayList<Item>();
	}

	@Override
	public void move(World world, Coord coord) {

		Coord newPosPersonnage = position.add(coord);
		MapElement mapElementNextPos = world.get(newPosPersonnage);

		if (mapElementNextPos.isMonster()) {
			fight(world.get(newPosPersonnage).content(), world);
		} else if (!mapElementNextPos.isCollidable()) {
			// swap d'element
			// System.out.println("Is Collidable");
			if (mapElementNextPos != null) {
				Element hero = world.get(position).content();
				// System.out.println("Symbole :" + hero.getSymbol());
				mapElementNextPos.putElement(hero);
				world.get(position).removeElement();
				position = newPosPersonnage;
			}
		}
	}

	public void fight(Element element, World world) {
		// 0 : personne mort, juste degats;
		// -1: hero mort, game over;
		// 1 : monster mort;
		Personnage.notifyChange("The hero and " + element.getSymbol()
				+ " fight!");
		if (element instanceof Personnage) {
			Personnage monster = (Personnage) element;
			this.attackCharacter(monster);
			monster.attackCharacter(this);
			if (this.isDead()) {
				Personnage.notifyChange("Hero dead - Game Over");
			} else if (monster.isDead()) {
				Personnage.notifyChange("Monster dead");
				world.get(monster.getPosition()).removeElement();
			}
		}
	}

	@Override
	public void open(World world, Coord coord, InputManager im) {
		// fonctionne seulement pour les portes
		Coord newPosition = position.add(coord);
		// TODO:Refactoriser et mettre dans MapElement/Element car c'est eux qui
		// gèrent l'ouverture

		// if (world.get(newPosition).isOpenable()) {

		// // Door
		if (world.get(newPosition).getSymbol() == '+') {
			MapElement door = world.get(newPosition);
			// TODO: getItem() pour rechercher un item dans l'inventaire;
			door.open(KeyFactory.getKey(null, 0));
			// Key heroKey = null; // heroKey.getItem();
			// if (heroKey != null) {
			// door.Open(heroKey);
			// Personnage.notifyChange("The door is open");
			// } else
			// Personnage
			// .notifyChange("You don't have the key for this door.");
		}
		// // Chest
		else if (world.get(newPosition).getSymbol() == ']') {

			Element chest = world.get(newPosition).content();
			// world.removeElement(chest);
			Item item = ((Chest) chest).open();
			Personnage.notifyChange("You find " + item.getName());
			// Personnage.notifyChange("Do you want to equip this item ; yes or no");
			// String answer = im.getInput();
			// if (answer.toLowerCase().equals("yes")) {
			// if (item instanceof Weapon) {
			// equipement.setArme((Weapon) item);
			// } else if (item instanceof Armor) {
			// equipement.setArmure((Armor) item);
			// } else if (item instanceof Shield) {
			// equipement.setShield((Shield) item);
			// }
			// }
			// world.setElement(chest);
			Personnage.notifyChange("The chest is open");
		} else {

			// // Door
			// if (world.getCharacter(newPosition) == '/') {
			// Personnage.notifyChange("The door is already open");
			// }
			// // Chest
			// else if (world.getCharacter(newPosition) == '[') {
			// Personnage.notifyChange("The chest is already open");
			// }
		}

		// Chest avec item
		// // if (world.getChar(newPos) == '[') {
		// // Item anItem = world.coffres.get(newPos).getBonus();
		// // String nameItem = anItem.getNom();
		// // Personnage.notifyChange("You found " + nameItem);
		// // hero.receivesShield(anItem);
		// }
		//

		// }

	}

	// TODO : implementer switch case selon le cas d'objet recu
	public void findItem() {

	}

	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public boolean isMonster() {
		return false;
	}
}
