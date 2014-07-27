package Game.MapElements;

import Game.Personnages.Element;

public abstract class MapElement {

	protected MapElement() {
	}

	public abstract char getSymbol();

	public abstract boolean isCollidable();
	
	public abstract boolean putElement(Element e);
	
	

}
