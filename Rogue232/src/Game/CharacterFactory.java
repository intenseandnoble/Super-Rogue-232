package Game;

public class CharacterFactory {

	
	private CharacterFactory(){
		
	}
	
	public static Character createHero(Coord coord){
		return new Character(coord, '@', 100, 20, 10);
	}
	
	public static Character createMonster(Coord coord){
		return new Character(coord,'a', 40, 15, 0);
	}
}
