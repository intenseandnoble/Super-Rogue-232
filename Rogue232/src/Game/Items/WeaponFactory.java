package Game.Items;

import java.util.Random;

public class WeaponFactory {

	private static final int DUMMYWEAPON = 0;
	private static final int NOOBYWEAPON = 1;

	public WeaponFactory() {
	}

	public static Weapon createDummyWeapon() {
		return new Weapon("Dummy Weapon", 5);
	}

	public static Weapon createNoobyWeapon() {
		return new Weapon("Nooby Weapon", 20);
	}

	public static Item getRandomWeapon() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(getWeaponListSize());
		switch (randomInt) {
		case DUMMYWEAPON:
			return createDummyWeapon();
		case NOOBYWEAPON:
			return createNoobyWeapon();
		default:
			return null;
		}
	}

	private static int getWeaponListSize() {
		// TODO Auto-generated method stub
		return 2;
	}
}
