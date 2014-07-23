package Game;

public class Armure extends Item{
	int defense;

	public Armure(String nom, int defense){
		super(nom);
		this.defense = defense;
	}
	
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
}
