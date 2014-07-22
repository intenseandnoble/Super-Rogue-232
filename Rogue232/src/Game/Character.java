package Game;

public class Character {
	/* Map variables */
	private Coord position;
	private char Symbol;
	
	/* Stats variables */
	private int hp;
	private int attack;
	private int defense;
	
	public Character() {
		position = new Coord(0,0);
		Symbol = '@';
	}
	public Character(Coord pos, char symbol, int lifepts, int atk, int def){
		position = pos;
		Symbol = symbol;
		hp = lifepts;
		attack = atk;
		defense = def;
	}
	
	public boolean isDead(){
		return hp<=0;
	}
	
	public void attackChar (Character monster){
		monster.takeDamage(attack);
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
		hp -= (enemyAtk-defense);
	}
	
	public int getAtk() {
		return attack;
	}
	
	public int getDef() {
		return defense;
	}
}
