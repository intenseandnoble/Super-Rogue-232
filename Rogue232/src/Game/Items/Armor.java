package Game.Items;

import java.util.ArrayList;
import java.util.Random;

public class Armor extends Item{
	int defense;

	public Armor(String nom, int defense){
		super(nom);
		this.defense = defense;
	}
	
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public static ArrayList<Armor> getArmorList(){
		return armorList;
	}
	
	@Override
	public void createArmorList(){
		getArmorList().add(createDummyArmor());
		getArmorList().add(createNoobyArmor());
	}
	
	private Armor createDummyArmor(){
		return new Armor("Dummy Armor", 5);
	}
	
	private Armor createNoobyArmor(){
		return new Armor("Nooby Armor", 10);
	}

	public static Item getRandomArmor() {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(getArmorList().size());
		return getArmorList().get(randomInt);
	}

	@Override
	protected void createConsumableList() {
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
