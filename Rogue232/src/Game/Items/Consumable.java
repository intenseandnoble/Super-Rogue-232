package Game.Items;

import java.util.ArrayList;
import java.util.Random;

public class Consumable extends Item{

	
		// Non implémenté (ex. potion de points de vie)
	int restorationPoints;
	
	public Consumable(String nom, int restorationPts) {
		super(nom);
		restorationPoints = restorationPts;
	}
	
	public static ArrayList<Consumable> getConsumableList(){
		return consumableList;		
	}
	
	@Override
	public void createConsumableList(){
		consumableList.add(createSmallHpPotion());
		consumableList.add(createMediumHpPotion());
	}
	
	private Consumable createSmallHpPotion(){
		return new Consumable("Hp Potion (S)", 10);
	}
	
	private Consumable createMediumHpPotion(){
		return new Consumable("Hp Potion (M)", 25);
	}
	
	public static Item getRandomConsumable() {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(getConsumableList().size());
		return getConsumableList().get(randomInt);
	}

	@Override
	protected void createArmorList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createShieldList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createWeaponList() {
		// TODO Auto-generated method stub
		
	}

}
