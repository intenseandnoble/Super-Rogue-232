package Game.MapElements;

import Game.Coord;
import Game.Character.Element;
import Game.Items.Key;
import Game.Items.KeyFactory;

public abstract class MapElement {

	protected Coord position;
	protected char symbol;

	public char getSymbol() {
		return symbol;
	}

	public void setPosition(Coord aPosition) {
		position = aPosition;
	}

	public Coord getPosition() {
		return position;
	}

	public Element getElement() {
		return null;
	}

	// Abstract method
	public abstract void putElement(Element content);

	public abstract void removeElement();

	public abstract boolean content();

	public abstract boolean isMonster();

	public MapElement clone() {
		if (this.getSymbol() == '.') {
			Floor tempF = new Floor();
			tempF.putElement(getElement());
			return tempF;
		}
		return MapElementFactory.createMapElement(this.getSymbol());
	}

	public boolean isOpenable() {
		return false;
	}

	public boolean canContent() {
		return false;
	}

	public boolean isCollidable() {
		return false;
	}
	
	public void open(Key key){}
	
	public Key getKey() {
		return KeyFactory.getKey(null, 0);
	}
	
	public boolean hasKey(){
		return false;
	}
}
