package Game.Items;

public class Weapon extends Item {
	int attaque;

	public Weapon(String nom, int att) {
		super(nom);
		attaque = att;
	}

	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}

}
