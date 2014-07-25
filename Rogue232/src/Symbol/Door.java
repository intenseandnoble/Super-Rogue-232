package Symbol;

import Game.Personnage;

public class Door extends Symbol {
	private boolean isOpen;
	private Personnage personnage;
	private boolean occupied;

	public Door(boolean openClose) {
		isOpen = openClose;
		personnage = null;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getSymbol() {
		//TODO: ajouter classe supérieur pour personnage/item pour getSymbol
		/*if (contient() != null) {
			return (contient()).getSymbol();
		} else */if (!isOpen) {
			return ']';
		}
		return '[';
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
}
