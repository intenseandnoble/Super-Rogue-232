package Game.Items;

import java.util.Random;

import Game.Coord;
import Game.Personnages.Element;

public class Chest extends Element {
	private Item bonus;
	private boolean isOpen;

	
	public Chest(Coord pos) {
		setPosition(pos);
		isOpen = false;
		this.symbol = ']';
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
	
	public Item Open(){
		Item item = getRandomItem();
		this.symbol = '[';
		return item;
	}
	
	private Item getRandomItem() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(100);
		if (randomInt < 20)
			return ArmorFactory.getRandomArmor();
		else if (randomInt < 40)
			return ConsumableFactory.getRandomConsumable();
		else if (randomInt < 60)
			return ShieldFactory.getRandomShield();
		else if (randomInt < 80)
			return WeaponFactory.getRandomWeapon();
		else
			// TODO: changer cas si 'null';
			return null;
	}
	
	public boolean isOpenable(){
		return symbol == ']';
	}
}
