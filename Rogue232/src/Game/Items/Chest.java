package Game.Items;

public class Chest extends Item {
	private Item bonus;
	private char symbole = '[';

	public Chest(Item b) {
		super("Chest");
		bonus = b;
		// TODO Auto-generated constructor stub
	}
	
	public Item getBonus(){
		return bonus;
	}
	
	public char getSymbole(){
		return symbole;
	}

}
