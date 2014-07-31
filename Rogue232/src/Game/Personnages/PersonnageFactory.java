package Game.Personnages;

import Game.Coord;

public class PersonnageFactory {

	
	private PersonnageFactory(){
		
	}
	
	public static Personnage createHero(Coord coord){
		return new Hero(coord);
	}
	
	public static Personnage createMonster(Coord coord){
		return new Monster(coord,'a', 40, 15, 0);
	}
}
