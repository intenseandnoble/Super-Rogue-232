package Game.MapElements;

import Game.Coord;

public abstract class MapElement {
	
	protected Coord position;
	protected char symbol;
	
	public char getSymbol(){
		return symbol;
	}
	
	public void setPosition(Coord aPosition){
		position = aPosition;
	}
	
	public Coord getPosition(){
		return position;
	}

	public abstract boolean isCollidable();
	
	public abstract boolean isMonster();
	
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
