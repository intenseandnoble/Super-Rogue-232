package Game.Items;

public class Armor extends Item {
	int defense;

	public Armor(String nom, int defense) {
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
