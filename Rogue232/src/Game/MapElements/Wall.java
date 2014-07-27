package Game.MapElements;

import Game.Personnages.Element;

public class Wall extends MapElement {
	private char symbol;

	public Wall(char symb) {
		symbol = symb;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public boolean isCollidable() {
		return true;
	}

	@Override
	public boolean putElement(Element e) {
		return false;
	}
}
