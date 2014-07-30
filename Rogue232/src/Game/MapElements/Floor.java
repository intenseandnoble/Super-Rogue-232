package Game.MapElements;

import Game.Coord;
import Game.Items.Chest;
import Game.Personnages.Element;

public class Floor extends MapElement {
	private Element element;
	private boolean occupied;
	
	public Floor()
	{
		element = null;
		symbol = '.';
		position = null;
		occupied = false;
	}

	public Floor(Coord aPosition) {
		element = null;
		symbol = '.';
		position = aPosition;
		occupied = false;
	}
	
	public Floor (Coord aPosition , Element aElement){
		element = aElement;
		symbol = '.';
		position = aPosition;
		occupied = true;
	}
	
	@Override
	public boolean isCollidable() {
		if (occupied) {
			return true;
		}
		return false;
	}

	public Element contient() {
		if (element != null)
			return element;
		else
			return null;
	}

	public boolean putElement(Element aElement) {
		if (!occupied) {
			element = aElement;
			occupied = true;
			return true; // SUCCESS!!
		}
		return false; // FAIL D:
	}
	
	public void removeElement(){
		element = null;
	}
	
	public boolean isMonster(){
		return element.isMonster();
	}
	
	public boolean isOpenable(){
		if (!occupied) {
			if(element.getSymbol() == ']'){
				return ((Chest)element).isOpenable();
			}
		}
		return false;
	}
	
	public char getSymbol(){
		if (element == null)
			return '.';
		return element.getSymbol();
	}
}
