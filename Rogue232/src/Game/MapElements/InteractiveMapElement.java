package Game.MapElements;

import Game.Personnages.Element;

public interface InteractiveMapElement {
	public Element contient();

	public boolean putElement(Element contient);

	public void removeElement();

}
