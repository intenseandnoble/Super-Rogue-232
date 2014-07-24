package Game.Items;

public class Consumable extends Item{

	
		// Non implémenté (ex. potion de points de vie)
	int nbUtil;
	
	public Consumable(String nom, int nbUtil) {
		super(nom);
		this.nbUtil = nbUtil;
	}

}
