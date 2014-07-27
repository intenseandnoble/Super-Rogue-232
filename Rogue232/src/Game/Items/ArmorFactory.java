package Game.Items;

import java.util.Random;

public class ArmorFactory {
	private static final int DUMMYARMOR = 0;
	private static final int NOOBYARMOR = 1;

	public ArmorFactory() {
	}

	public static Armor createDummyArmor() {
		return new Armor("Dummy Armor", 5);
	}

	public static Armor createNoobyArmor() {
		return new Armor("Nooby Armor", 10);
	}

	public static Item getRandomArmor() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(getArmorListSize());
		switch (randomInt) {
		case DUMMYARMOR:
			return createDummyArmor();
		case NOOBYARMOR:
			return createNoobyArmor();
		default:
			return null;
		}
	}

	private static int getArmorListSize() {
		// TODO Auto-generated method stub
		return 2;
	}

}
