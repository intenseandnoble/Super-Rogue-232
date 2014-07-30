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
	}
	
	public boolean isMonster(){
		return false;
	}
	
	public MapElement clone(){
		if(this.getSymbol() == '.'){
			Floor tempF = new Floor();
			tempF.putElement(((Floor)this).contient());
			return tempF;
		}
		return MapElementFactory.createMapElement(this.getSymbol());
	}
	
	public boolean isOpenable(){
		return false;
	}
}
