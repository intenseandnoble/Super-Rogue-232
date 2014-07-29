package Game.Items;

public class KeyFactory {
	public static Key getKey(String name , int keyNumber){
		if( name != "" || name != null)
			return new RealKey(name,keyNumber);
		else
			return new NullKey();
	}
}
