package Game.Items;

import java.util.ArrayList;
import java.util.Random;

public class Weapon extends Item{
	int attaque;

	public Weapon (String nom, int att){
		super(nom);
		attaque = att;
	}
	
	public int getAttaque() {
		return attaque;
	}

	public void setAttaque(int attaque) {
		this.attaque = attaque;
	}
	
	public static ArrayList<Weapon> getWeaponList(){
		return weaponList;
	}
	
	@Override
	public void createWeaponList(){
		weaponList.add(createDummyWeapon());
		weaponList.add(createNoobyWeapon());
	}
	
	private Weapon createDummyWeapon(){
		return new Weapon("Dummy Weapon", 5);
	}
	
	private Weapon createNoobyWeapon(){
		return new Weapon("Nooby Weapon", 20);
	}

	public static Item getRandomWeapon() {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(getWeaponList().size());
		return getWeaponList().get(randomInt);
	}

	@Override
	protected void createArmorList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createConsumableList() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void createShieldList() {
		// TODO Auto-generated method stub
		
	}
}
