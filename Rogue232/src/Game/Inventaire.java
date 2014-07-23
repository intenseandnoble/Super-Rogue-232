package Game;

import java.util.ArrayList;
import java.util.Iterator;

public class Inventaire implements Iterable<Item> {
	private ArrayList<Item> bag;

	public Inventaire(){
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

	public int getSize() {
		return bag.size();
	}

	@Override
	public Iterator<Item> iterator() {
		Iterator<Item> iBag = bag.iterator();
		return iBag;
	}

}