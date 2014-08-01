package Game;

import Game.Character.GameCharacter;
import Game.Items.Armor;
import Game.Items.ArmorFactory;
import Game.Items.Item;
import Game.Items.Shield;
import Game.Items.ShieldFactory;
import Game.Items.Weapon;
import Game.Items.WeaponFactory;

/*
 * Cette classe instancie l'equipement de l'hero.
 */

public class Equipment {
	Weapon weapon;
	Armor armor;
	Shield shield;

	public Equipment() {
		weapon = WeaponFactory.createNoobyWeapon();
		armor = ArmorFactory.createNoobyArmor();
		shield = ShieldFactory.createNoobyShield();
	}

	public Equipment(int i) {
		weapon = WeaponFactory.createDummyWeapon();
		armor = ArmorFactory.createDummyArmor();
		shield = ShieldFactory.createDummyShield();
	}

	public Weapon getWeapon() {
		return weapon;
	}

	public Armor getArmor() {
		return armor;
	}

	public Shield getShield() {
		return shield;
	}

	public void setEquipment(Item item) {
		if (item instanceof Weapon) {
			weapon = (Weapon) item;
			GameCharacter.notify("The new weapon " + item.getName() + " has been equipped");
		} else if (item instanceof Armor) {
			armor = (Armor) item;
			GameCharacter.notify("The new armor " + item.getName() + " has been equipped");
		} else if (item instanceof Shield) {
			shield = (Shield) item;
			GameCharacter.notify("The new shield " + item.getName() + " has been equipped");
		} else {
			GameCharacter.notify("You can't equip this item");
		}
	}
}
