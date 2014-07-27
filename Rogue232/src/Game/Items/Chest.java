package Game.Items;

import Game.Coord;
import Game.Personnages.Element;

public class Chest extends Element {
	private Item bonus;
	private boolean isOpen;


	public Chest(Coord pos) {
		setPosition(pos);
		isOpen = false;
	}
	
	public Chest(Item item) {
		putItem(item);
		isOpen = false;
	}

	public void putItem(Item item){
		bonus = item;
	}

	public Chest getChest() {
		return this;
	}
	
	public Item getBonus(){
		return bonus;
	}
	
	public char getSymbol(){
		if (!isOpen()) {
			return ']';
		}
		return '[';
	}
	
	public boolean isOpen(){
		return isOpen;
	}
	
	public Item getRandomItem(){
		return Item.getRandomItem();
	}
	

}
