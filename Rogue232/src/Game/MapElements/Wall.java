package Game.MapElements;

import Game.Personnages.Element;

public abstract class Wall extends MapElement {
	public Wall() {
		//polymorphisme, choisi si mur vertical ou horizontal
	}

	@Override
	public abstract char getSymbol();

	@Override
	public boolean isCollidable() {
		return true;
	}

	@Override
	public boolean putElement(Element e) {
		return false;
	}
}
