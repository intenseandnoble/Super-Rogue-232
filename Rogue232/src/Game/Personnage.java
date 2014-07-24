package Game;

import Game.Items.Armure;
import Game.Items.Shield;
import Game.Observer.ConcreteObserver;


// Cette classe fait les Heros et les monstres

public class Personnage {
	/* Map variables */
	private Coord position;
	private char Symbol;
	
	/* Stats variables */
	private int hp;
	private int attack;
	private int defense;
	
	static ConcreteObserver observer = new ConcreteObserver();
	
	/*Item*/
	private Equipement equipement;
	
	public Personnage(Coord coord) {
		position = coord;
		Symbol = '@';
		hp = 100;
		attack = 5;
		defense = 0;
		equipement = new Equipement();
		
//		observers = new ArrayList<ConcreteObserver>();
	}
	
	public Personnage(Coord pos, char symbol, int lifepts, int atk, int def){
		position = pos;
		Symbol = symbol;
		hp = lifepts;
		attack = atk;
		defense = def;
		equipement = new Equipement(1);
		
//		observers = new ArrayList<ConcreteObserver>();
	}
	
	public boolean isDead(){
		return hp<=0;
	}
	
	public void attackChar (Personnage monster){
		notifyChange("Monster attacks Hero");
		int damage = attack+equipement.getArme().getAttaque();
		monster.takeDamage(damage);
	}
	
	public char getSymbol(){
		return Symbol;
	}
	
	public Coord getPosition(){
		return position;
	}
	
	public void setPosition(Coord coord){
		position = coord;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void takeDamage(int enemyAtk){
		//TODO:Gerer hp bouclier, il faut pouvoir acceder au bag
		int carryOver = equipement.getShield().takeDamage(enemyAtk);
		int def = equipement.getArmure().getDefense();
		if (carryOver > 0){
			hp -= (carryOver-def);
		}
	}
	
	public int getAtk() {
		return attack;
	}
	
	public int getDef() {
		return defense;
	}
	
	public int afficheAtk() {
		int a = attack + equipement.getArme().getAttaque();
		return a;
	}
	
	public Shield getShield(){
		return equipement.getShield();
	}
	
	public Armure getArmure(){
		return equipement.getArmure();
	}
	
	public int afficheDef() {
		int d;
		//defense différente si le bouclier n'a plus de points de vie
		if(equipement.getShield().getHp()==0){
			d = defense + equipement.getArmure().getDefense();
		}
		else{
			d = defense + equipement.getArmure().getDefense() + equipement.getShield().getDefense();
		}
		return d;
	}
	
	public static void notifyChange(String action) 
	{
		observer.update(action);
	}
	
}
