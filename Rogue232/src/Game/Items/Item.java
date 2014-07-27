package Game.Items;


public abstract class Item {
	
	
	
	//ArrayList<Item> allItemLists = new ArrayList<Item>();

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

//	//TODO: Instancier liste des Items;
//	public void createItemsLists() {
//		createArmorList();
//		createConsumableList();
//		createShieldList();
//		createWeaponList();
//
///*		for (int i = 0; i < Armor.getArmorList().size(); i++) {
//			allItemLists.add(Armor.getArmorList().get(i));
//		}
//		
//		for (int i = 0; i < Consumable.getConsumableList().size(); i++) {
//			allItemLists.add(Consumable.getConsumableList().get(i));
//		}
//		
//		for (int i = 0; i < Shield.getShieldList().size(); i++) {
//			allItemLists.add(Shield.getShieldList().get(i));
//		}
//		
//		for (int i = 0; i < Weapon.getWeaponList().size(); i++) {
//			allItemLists.add(Weapon.getWeaponList().get(i));
//		}
//		
//		return allItemLists;*/
//	}



//	protected abstract void createArmorList();
//
//	protected abstract void createConsumableList();
//
//	protected abstract void createShieldList();
//
//	protected abstract void createWeaponList();

}
