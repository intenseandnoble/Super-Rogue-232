package Game.Items;

import java.util.Random;

public class ShieldFactory {

	private static final int DUMMYSHIELD = 0;
	private static final int NOOBYSHIELD = 1;

	// TODO : Peut-être de quoi a faire ici
	public ShieldFactory() {

	}

	public static Item getRandomShield() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(getShieldListSize());
		switch (randomInt) {
		case DUMMYSHIELD:
			return createDummyShield();
		case NOOBYSHIELD:
			return createNoobyShield();
		default:
			return null;
		}
	}

	// TODO : Ne plus l'avoir de hardcoder...
	private static int getShieldListSize() {
		return 2;
	}

	public static Shield createDummyShield() {
		return new Shield("Dummy Shield", 5, 0);
	}

	public static Shield createNoobyShield() {
		// Nom de l'item, résistance de l'arme, niveau de défense;
		return new Shield("NoobyShield", 10, 5);
	}

}
