package Symbol;

public class Wall extends Symbol {
	private char symbol;

	public Wall(char symb) {
		symbol = symb;
		// TODO Auto-generated constructor stub
	}

	@Override
	public char getSymbol() {
		return symbol;
	}

	@Override
	public boolean isCollidable() {
		return true;
	}
}
