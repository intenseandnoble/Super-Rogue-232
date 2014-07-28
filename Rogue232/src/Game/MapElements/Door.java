package Game.MapElements;

import Game.Items.*;
import Game.Personnages.*;

public abstract class Door extends MapElement {
	
	private boolean occupied;
	protected Element	element;
	protected Key 	key;
	private static Door door;
	
	protected Door(Element item, int key){
		this.element = item;
		if(item != null)
			occupied = true;
		else occupied = false;
		this.key = new Key("cle", key);  //si key=0 (clé bidon), alors la porte n'a pas besoin de clé
	}
	
	public static Door createDoor(Element e, int k){
		return door = new DoorClose(e, k);
	}
	
	public boolean getOccupied(){
		return occupied;
	}
	
	protected void setOccupied(){
		occupied = !(occupied);
	}
	
	public boolean putElement(Element e){
		if (!occupied) {
			element = e;
			occupied = true;
			return true; // SUCCESS!!
		}
		return false; // FAIL D:
	}
	
	public boolean openDoor(){
		if(key.getNoKey() == this.key.getNoKey()){
			door = new DoorOpen(element,this.key.getNoKey());
			return true; //is the great key, door open
		}
		return false; //is not key for this door
	}
	
	public abstract char getSymbol();
	public abstract boolean isCollidable();
	public abstract Element contient();
}
