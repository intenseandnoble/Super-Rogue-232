package Game;

public class Character {
	private Coord position;
	private char Symbol;
	
	public Character() {
		position = new Coord(0,0);
		Symbol = '@';
	}
	public Character(Coord pos, char symbol){
		position = pos;
		Symbol = symbol;
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
}
