package Game;

public class ItemFactory {
	private ItemFactory(){}
	
	static public Shield createDummyShield(){
		return new Shield("dummyShield", 0, 0);
	}
	
	static public Shield createShieldNoob(){
		//Nom de l'item, durabilité de l'arme, niveau de défense;
		return new Shield("NoobyShield", 10, 5);
	}
	
	static public Armure createDummyArmure(){
		return new Armure("dummyArmure", 0);
	}
	
	static public Armure createArmureNoob(){
		return new Armure("NoobyArmure", 10);
	}
	
	static public Arme createDummyArme(){
		return new Arme("dummyArme", 0);
	}
	
	static public Arme createArmeNoob(){
		return new Arme("NoobyArme", 20);
	}
	
	
}
