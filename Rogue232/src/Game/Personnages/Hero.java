package Game.Personnages;

import java.util.ArrayList;

import Game.Coord;
import Game.InputManager;
import Game.Inventaire;
import Game.World;
import Game.Items.Armor;
import Game.Items.Chest;
import Game.Items.Item;
import Game.Items.Key;
import Game.Items.Shield;
import Game.Items.Weapon;
import Game.MapElements.Door;

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

		if (world.isMonster(newPosPersonnage)) {
			fight(world.getPersonnage(newPosPersonnage), world);
		} else if (!world.isCollidable(newPosPersonnage)) {

			world.removePersonnage(position);
			this.setPosition(newPosPersonnage);
			world.addPersonnage(newPosPersonnage, this);
		}
	}

	public void fight(Personnage monster, World world) {
		// 0 : personne mort, juste d�g�ts;
		// -1: hero mort, game over;
		// 1 : monster mort;
		Personnage.notifyChange("The hero and " + monster.getSymbol()
				+ " fight!");
		this.attackCharacter(monster);
		monster.attackCharacter(this);
		if (this.isDead()) {
			Personnage.notifyChange("Hero dead");
		} else if (monster.isDead()) {
			Personnage.notifyChange("Monster dead");
			world.removePersonnage(monster.getPosition());
		}
	}

	@Override
	public void open(World world, Coord coord, InputManager im) {
		// fonctionne seulement pour les portes
		Coord newPosition = position.add(coord);
		if (world.isOpenable(newPosition)) {
			// Door
			if (world.getCharacter(newPosition) == '+') {
				Door door = (Door) world.getoWorld().get(newPosition);
				//TODO: getItem() pour rechercher un item dans l'inventaire;
				Key heroKey = null; //heroKey.getItem();
				if (heroKey != null) {
					door.Open(heroKey);
					Personnage.notifyChange("The door is open");
				}
				else Personnage.notifyChange("You don't have the key for this door.");
			}
			// Chest
			else if (world.getCharacter(newPosition) == ']') {
				Chest chest = (Chest) world.getElement(newPosition);
				world.removeElement(chest);
				Item item = chest.Open();
				Personnage.notifyChange("You find " + item.getName());
				Personnage
						.notifyChange("Do you want to equip this item ; yes or no");
				String answer = im.getInput();
				if (answer.toLowerCase().equals("yes")) {
					if (item instanceof Weapon) {
						equipement.setArme((Weapon) item);
					} else if (item instanceof Armor) {
						equipement.setArmure((Armor) item);
					} else if (item instanceof Shield) {
						equipement.setShield((Shield) item);
					}
				}
				world.setElement(chest);
				Personnage.notifyChange("The chest is open");
			} else {
				// Door
				if (world.getCharacter(newPosition) == '/') {
					Personnage.notifyChange("The door is already open");
				}
				// Chest
				else if (world.getCharacter(newPosition) == '[') {
					Personnage.notifyChange("The chest is already open");
				}
			}
			// if (world.getChar(newPos) == '[') {
			// Item anItem = world.coffres.get(newPos).getBonus();
			// String nameItem = anItem.getNom();
			// Personnage.notifyChange("You found " + nameItem);
			// hero.receivesShield(anItem);
			// }

		}
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

}
