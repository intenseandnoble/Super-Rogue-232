package Game.Items;

public class Key extends Item {
	
	private int noKey;

	public Key(String nom, int no) {
		super(nom);
		// TODO Auto-generated constructor stub
		noKey = no; //identifiant de la cl� associ� � une porte, si 0=cl� bidon
	}

	public int getNoKey(){
		return noKey;
	}
}
