package Game;

public class Chest extends Item {
	private Item bonus;

	public Chest(Item b) {
		super("Chest");
		bonus = b;
		// TODO Auto-generated constructor stub
	}
	
	public Item getBonus(){
		return bonus;
	}

}
