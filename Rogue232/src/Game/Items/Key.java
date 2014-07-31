package Game.Items;

public abstract class Key extends Item {

	protected int keyNumber;
	boolean isNull;

	public Key() {
		super();
	}

	public Key(String nom) {
		super(nom);
	}

	public int getNumber() {
		return keyNumber;
	}

	public String getName() {
		return getName();
	}

	public abstract boolean isNull();
}
