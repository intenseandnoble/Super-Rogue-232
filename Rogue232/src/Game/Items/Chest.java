package Game.Items;
import Game.Coord;

public class Chest extends Item {
	private Item bonus;
	private char symbole = '[';
	private Coord position;

	public Chest(Item b) {
		super("Chest");
		bonus = b;
		// TODO Auto-generated constructor stub
	}
	
	public Chest getChest() {
		return this;
	}
	
	public Item getBonus(){
		return bonus;
	}
	
	public char getSymbole(){
		return symbole;
	}
	
	public Coord getPosition() {
		return position;
	}

	public void setPosition(Coord position) {
		this.position = position;
	}

}
