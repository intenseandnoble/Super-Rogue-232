package Game.Items;

import java.util.Random;

public class ConsumableFactory {
	private static final int SMALLHPPOTION = 0;
	private static final int MEDIUMHPPOTION = 1;

	public ConsumableFactory() {

	}

	public static Consumable createSmallHpPotion() {
		return new Consumable("Hp Potion (S)", 10);
	}

	public static Consumable createMediumHpPotion() {
		return new Consumable("Hp Potion (M)", 25);
	}

	public static Item getRandomConsumable() {
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(getConsumabledListSize());
		switch (randomInt) {
		case SMALLHPPOTION:
			return createSmallHpPotion();
		case MEDIUMHPPOTION:
			return createMediumHpPotion();
		default:
			return null;
		}
	}

	private static int getConsumabledListSize() {
		// TODO Auto-generated method stub
		return 2;
	}

}
