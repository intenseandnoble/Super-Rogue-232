package Game.Personnages;

import Game.Coord;
import Game.World;

public class Hero extends Personnage {

	private int gold;
	
	public Hero(Coord coord) {
		super(coord);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void move(World world, Coord coord) {
		// TODO: changer test pour mettre private
		Coord newPosPersonnage = position.add(coord);

		if (!world.isCollidable(newPosPersonnage)) {
			this.setPosition(newPosPersonnage);
			Personnage tmpPersonnage = world.getPersonnage(position);
			world.deletePersonnage(position);
			world.addPersonnage(newPosPersonnage, tmpPersonnage);
		}

	}
	
	//TODO : implementer switch case selon le cas d'objet recu
	public void findsItem() {
		
	}
	
	public int getGold() {
		return gold;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}
	
}
