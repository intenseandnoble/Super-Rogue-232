package Game;

import Game.Items.Armor;
import Game.Items.ArmorFactory;
import Game.Items.Shield;
import Game.Items.ShieldFactory;
import Game.Items.Weapon;
import Game.Items.WeaponFactory;

/*
 * Cette classe instancie l'equipement de l'hero.
 */

public class Equipement {
	Weapon arme;
	Armor armure;
	Shield shield;

	public Equipement() {
		arme = WeaponFactory.createNoobyWeapon();
		armure = ArmorFactory.createNoobyArmor();
		shield = ShieldFactory.createNoobyShield();
	}

	 public Equipement(int i){
	 arme = WeaponFactory.createDummyWeapon();
	 armure = ArmorFactory.createDummyArmor();
	 shield = ShieldFactory.createDummyShield();
	 }

	public Weapon getArme() {
		return arme;
	}

	public void setArme(Weapon arme) {
		this.arme = arme;
	}

	public Armor getArmure() {
		return armure;
	}

	public void setArmure(Armor armure) {
		this.armure = armure;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}

}
