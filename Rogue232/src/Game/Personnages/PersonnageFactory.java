package Game.Personnages;

import Game.Coord;

public class PersonnageFactory {

	
	private PersonnageFactory(){
		
	}
	
	public static Personnage createHero(Coord coord){
		return new Personnage(coord);
	}
	
	public static Personnage createMonster(Coord coord){
		return new Personnage(coord,'a', 40, 15, 0);
	}
}
