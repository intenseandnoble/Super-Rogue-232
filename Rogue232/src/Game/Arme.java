package Game;

public class Arme extends Item{
	int attaque;

	public Arme (String nom, int att){
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
