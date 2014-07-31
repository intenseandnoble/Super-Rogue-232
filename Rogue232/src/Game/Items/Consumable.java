package Game.Items;

public class Consumable extends Item {

	// Non implémenté (ex. potion de points de vie)
	int restorationPoints;

	public Consumable(String nom, int restorationPts) {
		super(nom);
		restorationPoints = restorationPts;
	}

}
