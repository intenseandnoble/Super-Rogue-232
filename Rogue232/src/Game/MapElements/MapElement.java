package Game.MapElements;

import Game.Coord;

public class MapElement {
	
	protected Coord position;
	protected char symbol;

	public char getSymbol(){
		return symbol;
	}
	
	public void setPostion(Coord aPosition){
		position = aPosition;
	}

	public boolean isCollidable(){
		return false;
	};
}
