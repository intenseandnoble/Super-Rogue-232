package Game.Items;

public abstract class Item {

	String name;

	public Item() {
		name = null;
	}

	public Item(String nom) {
		this.name = nom;
	}

	public String getName() {
		return name;
	}

	public void setName(String nom) {
		this.name = nom;
	}

	public boolean isConsumable() {
		return false;
	}

}
