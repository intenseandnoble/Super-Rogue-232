package Game;

import Game.Items.Armor;
import Game.Items.ItemFactory;
import Game.Items.Shield;
import Game.Items.Weapon;
import Game.Items.WeaponFactory;

public class Equipement {
	Weapon arme;
	Armor armure;
	Shield shield;
	
	public Equipement(){
		arme = WeaponFactory.createNoobyWeapon();
		armure = ItemFactory.createArmureNoob();
		shield = ItemFactory.createShieldNoob();
	}
	
	public Equipement(int i){
		arme = ItemFactory.createDummyArme();
		armure = ItemFactory.createDummyArmure();
		shield = ItemFactory.createDummyShield();
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
