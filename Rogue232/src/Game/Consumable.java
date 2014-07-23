package Game;

public class Consumable extends Item{

	int nbUtil;
	
	public Consumable(String nom, int nbUtil) {
		super(nom);
		this.nbUtil = nbUtil;
	}

}
