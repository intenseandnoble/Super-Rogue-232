package Game.Items;

import Game.Coord;

public class Element {
	// Variables
	protected Coord Position;
	protected char Symbol;
	// Get and Set
	public Coord getPosition(){
		return Position;
	}
	public void setPosition(Coord aPosition){
		Position = aPosition;
	}
	public char getSymbol(){
		return Symbol;
	}
}
