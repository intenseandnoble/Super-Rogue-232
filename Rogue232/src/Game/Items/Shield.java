package Game.Items;

public class Shield extends Item {
	int hp;
	int defense;

	public Shield(String nom, int hp, int defense) {
		super(nom);
		this.hp = hp;
		this.defense = defense;
	}

	public int takeDamage(int enemyAtk) {
		if (hp == 0) {
			return enemyAtk;
		}
		if (defense > enemyAtk) {
			return 0;
		} else {
			hp -= (enemyAtk - defense);
			int carryOver = hp;
			if (hp < 0) {
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

}
