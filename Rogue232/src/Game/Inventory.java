package Game;

import java.util.ArrayList;
import java.util.Iterator;

import Game.Character.GameCharacter;
import Game.Items.Item;

public class Inventory implements Iterable<Item> {
	private ArrayList<Item> bag;

	public Inventory() {
		bag = new ArrayList<Item>();
	}

	public void addItemBag(Item item) {
		bag.add(item);
	}

	public void removeItemBag(Item item) {
		bag.remove(item);
	}

	public void getItem(int x) {
		bag.get(x);
	}
	
	public boolean isContent(Item item){
		return bag.contains(item);
	}

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iBag = bag.iterator();
		return iBag;
	}
	
	public void printBag(){
		if(!bag.isEmpty())
		{
			for(Item item: bag){
				GameCharacter.notify(item.getName());
			}
		}
		else GameCharacter.notify("no item");
	}

	public boolean isEmpty() {
		if(bag.isEmpty())
			return true;
		return false;
	}
}
