package Game.Items;

import java.util.ArrayList;
import java.util.Random;

public abstract class Item {
	static ArrayList<Armor> armorList = new ArrayList<Armor>();
	static ArrayList<Consumable> consumableList = new ArrayList<Consumable>();
	static ArrayList<Shield> shieldList = new ArrayList<Shield>();
	static ArrayList<Weapon> weaponList = new ArrayList<Weapon>();
	ArrayList<Item> allItemLists = new ArrayList<Item>();

	String nom;

	public Item(String nom) {
		this.nom = nom;
	}

	public String getName() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	//TODO: Instancier liste des Items;
	public void createItemsLists() {
		createArmorList();
		createConsumableList();
		createShieldList();
		createWeaponList();

/*		for (int i = 0; i < Armor.getArmorList().size(); i++) {
			allItemLists.add(Armor.getArmorList().get(i));
		}
		
		for (int i = 0; i < Consumable.getConsumableList().size(); i++) {
			allItemLists.add(Consumable.getConsumableList().get(i));
		}
		
		for (int i = 0; i < Shield.getShieldList().size(); i++) {
			allItemLists.add(Shield.getShieldList().get(i));
		}
		
		for (int i = 0; i < Weapon.getWeaponList().size(); i++) {
			allItemLists.add(Weapon.getWeaponList().get(i));
		}
		
		return allItemLists;*/
	}

	public static Item getRandomItem() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if (randomInt < 20)
			return Armor.getRandomItem();
		else if (randomInt < 40)
			return Consumable.getRandomItem();
		else if (randomInt < 60)
			return Shield.getRandomItem();
		else if (randomInt < 80)
			return Weapon.getRandomItem();
		else
			// TODO: changer cas si 'null';
			return null;
	}

	protected abstract void createArmorList();

	protected abstract void createConsumableList();

	protected abstract void createShieldList();

	protected abstract void createWeaponList();

}
