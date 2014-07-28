package Game.MapElements;

import Game.Items.*;
import Game.Personnages.Element;

class DoorClose extends Door {
	
	private char symbol = '+';

	public DoorClose(Element e, int key) {
		super(e, key);
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public boolean isCollidable() {
		return true;
	}

	//null car s'il y a un element, il n'est pas visible étant une porte fermé
	@Override
	public Element contient() {
		return null;
	}

	//BUZZ à corriger putElement n'existe plus dans Door
	@Override
	public boolean putElement(Element e) {
		return true;
	}
}
