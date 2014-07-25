package Symbol;

import Game.Personnage;
import Game.Items.Item;

public class Floor extends Symbol {
	private Personnage personnage;
	private Item item;
	private boolean occupied;

	public Floor() {
		personnage = null;
		item = null;
	}

	@Override
	public char getSymbol() {
		//TODO: ajouter classe supérieur pour personnage/item pour getSymbol et isCollidable() 
				/*if (contient() != null) {
					return (contient()).getSymbol();
				} else */
		return '.';
	}

	@Override
	public boolean isCollidable() {
		if (occupied) {
			return true;
		}
		return false;
	}

	protected Object contient() {
		if (personnage != null)
			return personnage;
		else if (item != null)
			return item;
		else
			return null;
	}

	public boolean putPersonnage(Personnage personnage) {
		if (!occupied) {
			this.personnage = personnage;
			occupied = true;
			return true; // SUCCESS!!
		}
		return false; // FAIL D:
	}

	public boolean putItem(Item item) {
		if (!occupied) {
			this.item = item;
			occupied = true;
			return true; // SUCCESS!!
		}
		return false; // FAIL D:
	}

}
