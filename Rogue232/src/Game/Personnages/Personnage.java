package Game.Personnages;

import Game.Coord;
import Game.Equipement;
import Game.World;
import Game.Items.Armure;
import Game.Items.Element;
import Game.Items.Shield;
import Game.Observer.AppendTextObserver;

// Cette classe fait les Heros et les monstres

public class Personnage extends Element {
	/* Map variables */
//	private Coord position;
//	private char Symbol;

	/* Stats variables */
	private int hp;
	private int attack;
	private int defense;
	

	static AppendTextObserver observer = new AppendTextObserver();

	/* Item */
	private Equipement equipement;

	public Personnage(Coord coord) {
		position = coord;
		symbol = '@';
		hp = 100;
		attack = 5;
		defense = 0;
		equipement = new Equipement();

		// observers = new ArrayList<ConcreteObserver>();
	}

	public Personnage(Coord pos, char symbol, int lifepts, int atk, int def) {
		position = pos;
		this.symbol = symbol;
		hp = lifepts;
		attack = atk;
		defense = def;
		equipement = new Equipement(1);	

		// observers = new ArrayList<ConcreteObserver>();
	}
	
	public void move(World world, Coord coord) {
		
	}

	public boolean isDead() {
		return hp <= 0;
	}

	public void attackChar(Personnage monster) {
//		notifyChange(monster.getSymbol() + " attacks " + this.getSymbol()) ;
		int damage = attack + equipement.getArme().getAttaque();
		monster.takeDamage(damage);
	}

	public int getHp() {
		return hp;
	}

	public void takeDamage(int enemyAtk) {
		// TODO:Gerer hp bouclier, il faut pouvoir acceder au bag
		int carryOver = equipement.getShield().takeDamage(enemyAtk);
		int def = equipement.getArmure().getDefense();
		if (carryOver > 0) {
			hp -= (carryOver - def);
		} else {
			Personnage.notifyChange("Shield's broken");
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

	public Shield getShield() {
		return equipement.getShield();
	}
	

	public Armure getArmure() {
		return equipement.getArmure();
	}

	public int afficheDef() {
		int d;
		// defense différente si le bouclier n'a plus de points de vie
		if (equipement.getShield().getHp() == 0) {
			d = defense + equipement.getArmure().getDefense();
		} else {
			d = defense + equipement.getArmure().getDefense()
					+ equipement.getShield().getDefense();
		}
		return d;
	}

	public static void notifyChange(String action) {
		observer.update(action);
	}



	
}
