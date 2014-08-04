package Game.Character;

import Game.Coord;
import Game.Equipment;
import Game.InputManager;
import Game.World;
import Game.Items.Armor;
import Game.Items.Shield;
import Game.Observer.AppendTextObserver;

// Cette classe fait les Heros et les monstres

public abstract class GameCharacter extends Element {
	/* Map variables */
	// private Coord position;
	// private char Symbol;

	/* Stats variables */
	private int hp;
	private int attack;
	private int defense;

	static AppendTextObserver observer = new AppendTextObserver();

	/* Item */
	protected Equipment equipement;

	public GameCharacter(Coord coord) {
		position = coord;
		symbol = '@';
		hp = 100;
		attack = 5;
		defense = 0;
		equipement = new Equipment();
	}

	// TODO; polymorphisme nécessaire?
	public GameCharacter(Coord pos, char symbol, int lifepts, int atk, int def) {
		position = pos;
		this.symbol = symbol;
		hp = lifepts;
		attack = atk;
		defense = def;
		equipement = new Equipment(1);
	}

	public void move(World world, Coord coord) {

	}

	public void open(World world, Coord coord, InputManager im) {

	}

	public boolean isDead() {
		return hp <= 0;
	}

	public void attackCharacter(GameCharacter monster) {
		// notifyChange(monster.getSymbol() + " attacks " + this.getSymbol()) ;
		int damage = attack + equipement.getWeapon().getAttaque();
		monster.takeDamage(damage);
	}

	public void attackHero() {
	}

	public int getHp() {
		return hp;
	}

	public void takeDamage(int enemyAtk) {
		int carryOver = equipement.getShield().takeDamage(enemyAtk);
		int def = equipement.getArmor().getDefense();
		if (!isMonster()) {
			if (carryOver > 0) {
				hp -= (carryOver - def);
			} else {
				GameCharacter.notify("Shield's broken");
			}
		}
	}

	public int getAtk() {
		return attack;
	}

	public int getDef() {
		return defense;
	}

	public int afficheAtk() {
		int a = attack + equipement.getWeapon().getAttaque();
		return a;
	}

	public Shield getShield() {
		return equipement.getShield();
	}

	public Armor getArmure() {
		return equipement.getArmor();
	}

	public int afficheDef() {
		int d;
		// defense différente si le bouclier n'a plus de points de vie
		if (equipement.getShield().getHp() == 0) {
			d = defense + equipement.getArmor().getDefense();
		} else {
			d = defense + equipement.getArmor().getDefense()
					+ equipement.getShield().getDefense();
		}
		return d;
	}

	public static void notify(String action) {
		observer.update(action);
	}

	@Override
	public GameCharacter clone() {
		try {
			return (GameCharacter) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			return null;
		}
	}

}
