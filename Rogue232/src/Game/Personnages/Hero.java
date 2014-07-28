package Game.Personnages;

import Game.Coord;
import Game.World;
import Game.Items.Item;

public class Hero extends Personnage {

	private int gold;
	
	public Hero(Coord coord) {
		super(coord);
	}

	@Override
	public void move(World world, Coord coord) {
		Coord newPosPersonnage = position.add(coord);
		
		if (world.isMonster(newPosPersonnage)) {
			fight(world.getPersonnage(newPosPersonnage), world);
		}
		else if (!world.isCollidable(newPosPersonnage)) {
			
			world.removePersonnage(position);
			this.setPosition(newPosPersonnage);
			world.addPersonnage(newPosPersonnage, this);
		}
	}
	
	public void fight(Personnage monster, World world) {
	// 0 : personne mort, juste d�g�ts;
	// -1: hero mort, game over;
	// 1 : monster mort;
	Personnage.notifyChange("The hero and " + monster.getSymbol() + " fight!");
	this.attackCharacter(monster);
	monster.attackCharacter(this);
	if (this.isDead()){
		Personnage.notifyChange("Hero dead");
		}
	else if (monster.isDead()){
		Personnage.notifyChange("Monster dead");
		world.removePersonnage(monster.getPosition());
		}
	}	
	
	@Override
	public void open(World world, Coord coord) {
		// fonctionne seulement pour les portes
		Coord newPos = position.add(coord);
		
		if (world.isOpenable(newPos)) {
//			System.out.println(world.getChar(position));
			world.setChar(newPos, world.getOpenTo().get(world.getChar(newPos)).charValue());
			Personnage.notifyChange("It's opened");
			
//			if (world.getChar(newPos) == '[') {
//				Item anItem = world.coffres.get(newPos).getBonus();
//				String nameItem = anItem.getNom();
//				Personnage.notifyChange("You found " + nameItem);
//				hero.receivesShield(anItem);
//			}
			
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
