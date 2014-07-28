package Game.MapElements;

import Game.Items.*;
import Game.Personnages.Element;

class DoorOpen extends Door {
	
	private char symbol = '/';
	
	protected DoorOpen(Element e, int key){
		super(e, key);
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public boolean isCollidable() {
		if (getOccupied()) {
			return true;
		}
		return false;
	}

	@Override
	public Element contient() {
		return element;
	}
	
	//Lorsque l'item ramasser item disparait
	public Element getItem(){
		Element temp = element;
		element = null;
		setOccupied();
		return temp;
	}

	//BUZZ à corriger putElement n'existe plus dans Door
	@Override
	public boolean putElement(Element e) {
		return false;
	}
}
