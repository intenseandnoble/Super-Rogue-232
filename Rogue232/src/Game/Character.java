package Game;

public class Character {
	private Coord position;
	private char Symbol;
	private int hp;
	
	public Character() {
		position = new Coord(0,0);
		Symbol = '@';
		hp = 5;
	}
	public Character(Coord pos, char symbol, int hp){
		position = pos;
		Symbol = symbol;
		this.hp = hp;
	}
	
	public char getSymbol(){
		return Symbol;
	}
	
	public Coord getPosition(){
		return position;
	}
	
	public void setPosition(int x, int y){
		position.setXY(x, y);
	}
	
	public void setPosition(Coord coord){
		position = coord;
	}
	
	public void getHit(int damage){
		hp -= damage;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
}
