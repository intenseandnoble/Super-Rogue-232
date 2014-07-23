package Game;

public class Equipement {
	Arme arme;
	Armure armure;
	Shield shield;
	
	public Equipement(){
		arme = ItemFactory.createArmeNoob();
		armure = ItemFactory.createArmureNoob();
		shield = ItemFactory.createShieldNoob();
	}
	
	public Equipement(int i){
		arme = ItemFactory.createDummyArme();
		armure = ItemFactory.createDummyArmure();
		shield = ItemFactory.createDummyShield();
	}
	
	public Arme getArme() {
		return arme;
	}

	public void setArme(Arme arme) {
		this.arme = arme;
	}

	public Armure getArmure() {
		return armure;
	}

	public void setArmure(Armure armure) {
		this.armure = armure;
	}

	public Shield getShield() {
		return shield;
	}

	public void setShield(Shield shield) {
		this.shield = shield;
	}
	
}
