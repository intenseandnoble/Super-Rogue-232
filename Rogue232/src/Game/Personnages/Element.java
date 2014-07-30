package Game.Personnages;

import Game.Coord;
import Game.MapElements.Floor;
import Game.MapElements.MapElement;
import Game.MapElements.MapElementFactory;

public class Element {
	// Variables
	protected Coord position;
	protected char symbol;
	
	// Get and Set
	public Coord getPosition(){
		return position;
	}
	public void setPosition(Coord aPosition){
		position = aPosition;
	}
	public char getSymbol(){
		return symbol;
	}
	
	public boolean isMonster(){
		return false;
	}
	
	public boolean isOpenable(){
		return false;
	}
}
