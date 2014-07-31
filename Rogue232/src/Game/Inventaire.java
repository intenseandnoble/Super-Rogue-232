package Game;

import java.util.ArrayList;
import java.util.Iterator;

import Game.Items.Item;

public class Inventaire implements Iterable<Item> {
	private ArrayList<Item> bag;

	public Inventaire() {
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

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iBag = bag.iterator();
		return iBag;
	}

}
