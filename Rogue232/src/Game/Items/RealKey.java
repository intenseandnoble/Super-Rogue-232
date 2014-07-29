package Game.Items;

public class RealKey extends Key {

	public RealKey(String name, int aKeyNumber){
		super(name);
		keyNumber = aKeyNumber;
	}

	@Override
	public boolean isNull() {		
		return false;
	}
}
