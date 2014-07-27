package Game.Items;

import java.util.ArrayList;
import java.util.Random;

public class Shield extends Item{
	int hp;
	int defense;

	public Shield(String nom, int hp, int defense){
		super(nom);
		this.hp = hp;
		this.defense = defense;
	}
	
	public int takeDamage(int enemyAtk){
		if (hp == 0){
			return enemyAtk;
		}
		if (defense > enemyAtk){
			return 0;
		} else {
			hp -= (enemyAtk-defense);
			int carryOver = hp;
			if (hp < 0){
				hp = 0;
			}
			return carryOver;
		}
	}
	
	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}
	
	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public static ArrayList<Shield> getShieldList(){
		return shieldList;		
	}
	
	public static Item getRandomShield() {
		Random randomGenerator = new Random();
		 int randomInt = randomGenerator.nextInt(getShieldList().size());
		return getShieldList().get(randomInt);
	}
	
	@Override
	public void createShieldList(){
		shieldList.add(createDummyShield());
		shieldList.add(createNoobyShield());
	}
	
	private Shield createDummyShield(){
		return new Shield("Dummy Shield", 5, 0);
	}
	
	private Shield createNoobyShield(){
		//Nom de l'item, résistance de l'arme, niveau de défense;
		return new Shield("NoobyShield", 10, 5);
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
	protected void createWeaponList() {
		// TODO Auto-generated method stub
		
	}
}
