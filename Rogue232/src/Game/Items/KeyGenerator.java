package Game.Items;

public class KeyGenerator {
	static int keyNumber = 1;
	public static int getKeyNumber(){
		return keyNumber++;
	}
	
}
