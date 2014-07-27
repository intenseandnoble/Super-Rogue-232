package Game.Items;

public class ItemFactory {
	private ItemFactory(){}
	
	static public Shield createDummyShield(){
		return new Shield("dummyShield", 0, 0);
	}
	
	static public Shield createShieldNoob(){
		//Nom de l'item, durabilité de l'arme, niveau de défense;
		return new Shield("NoobyShield", 10, 5);
	}
	
	static public Armor createDummyArmure(){
		return new Armor("dummyArmure", 0);
	}
	
	static public Armor createArmureNoob(){
		return new Armor("NoobyArmure", 10);
	}
	
	static public Weapon createDummyArme(){
		return new Weapon("dummyArme", 0);
	}
	
	static public Weapon createArmeNoob(){
		return new Weapon("NoobyArme", 20);
	}
	
	
}
