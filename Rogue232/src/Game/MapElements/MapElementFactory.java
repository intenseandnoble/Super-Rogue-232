package Game.MapElements;

public class MapElementFactory {
	protected MapElementFactory() {
	}
 //TODO faire abstraction pour eliminer switch case
	public static MapElement createMapElement(char c) {
		switch (c) {
		case '-':
			return new Wall("horizontal");
		case '|':
			return new Wall("vertical");
		case '+':
			return new Door(false);
		case '/':
			return new Door(true);
		case '.':
			return new Floor();
		default:
			throw new IllegalArgumentException("Char not valid");
		}
	}
}