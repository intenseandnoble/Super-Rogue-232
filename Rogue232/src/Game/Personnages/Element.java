package Game.Personnages;

import org.hamcrest.CoreMatchers;

import Game.Coord;

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
}
