package Game;

import java.util.ArrayList;

public class Item {
	private ArrayList<Item> bag;
	private int hp;
	private int armor;
	private Item shield;

	public Item(int HP, int Armor) {
		hp = HP;
		armor = Armor;
	}

	private void createBag(){
		bag.add(Item.createShield());//cree bouclier vide, non utile
	}
	
	public void addItemBag(Item item) {
		bag.add(item);
	}

	public void removeItemBag(Item item) {
		bag.remove(item);
	}

	public ArrayList<Item> getBag() {
		return bag;
	}

	public static Item createShield() {
		Item shield = new Item(0, 0);
		return shield;
	}

	public Item getShield() {
		return shield;
	}

	public void setShield(int h, int a) {
		shield.hp = h;
		shield.armor = a;
	}

}
