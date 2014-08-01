package Game.Character;

import java.util.ArrayList;

import Game.Coord;
import Game.InputManager;
import Game.Inventory;
import Game.World;
import Game.Items.Chest;
import Game.Items.Item;
import Game.Items.KeyFactory;
import Game.MapElements.MapElement;

public class Hero extends GameCharacter {

	private int gold;
	private Inventory heroBag;

	public Hero(Coord coord) {
		super(coord);
		heroBag = new Inventory();
	}

	@Override
	public void move(World world, Coord coord) {

		Coord newPosPersonnage = position.add(coord);
		MapElement mapElementNextPos = world.get(newPosPersonnage);

		if (mapElementNextPos.isMonster()) {
			fight(world.get(newPosPersonnage).getElement(), world);
		} else if (!mapElementNextPos.isCollidable()) {
			if (mapElementNextPos != null) {
				Element hero = world.get(position).getElement();
				mapElementNextPos.putElement(hero);
				world.get(position).removeElement();
				position = newPosPersonnage;
			}
		}
	}

	public void fight(Element element, World world) {
		GameCharacter.notify("The hero and " + element.getSymbol()
				+ " fight!");
		if (element instanceof GameCharacter) {
			GameCharacter monster = (GameCharacter) element;
			this.attackCharacter(monster);
			monster.attackCharacter(this);
			if (this.isDead()) {
				GameCharacter.notify("Hero dead - Game Over");
			} else if (monster.isDead()) {
				GameCharacter.notify("Monster dead");
				world.get(monster.getPosition()).removeElement();
			}
		}
	}

	@Override
	public void open(World world, Coord coord, InputManager im) {
		Coord newPosition = position.add(coord);
		// Door
		if (world.get(newPosition).isOpenable()) {
			MapElement door = world.get(newPosition);
			if(door.hasKey()){
				if(heroBag.isContent(door.getKey())){
					door.open(door.getKey());
				}
				else{
					notify("You dont have the key to open the door");
				}
			}
		}
		// Chest
		else if (world.get(newPosition).content()){
			if(world.get(newPosition).getElement().isOpenable()){
				Chest chest = (Chest)world.get(newPosition).getElement();
				Item item = chest.open();
				if(item!=null){
					notify("You found " + item.getName());
					if(!item.isConsumable()){
						notify("Do you want to equip this item ? \n  ( yes or no )");
						String answer = im.getInput();
						if (answer.toLowerCase().equals("yes")) {
							equipement.setEquipment(item);
						}
					}
					else{
						heroBag.addItemBag(item);
						notify("This item has been added to your bag");
					}
				}
				else{
					notify("nothing found!");
				}
			}
		} 
		else {
			notify("Is already open");
		}
	}

	public int getGold() {
		return gold;
	}
	
	public Inventory getBag(){
		return heroBag;
	}

	public void setGold(int gold) {
		this.gold = gold;
	}

	public boolean isMonster() {
		return false;
	}
}
