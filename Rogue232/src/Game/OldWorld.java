package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Game.Items.Chest;
import Game.MapElements.MapElement;
import Game.Personnages.Element;
import Game.Personnages.Personnage;



/* Est-ce que ce code est encore utilisé, si non, on peut le détruire */


public class OldWorld implements Iterable<char[]> {
	ArrayList<char[]> data = new ArrayList<char[]>();
	private char[] collidable = { '|', ' ', '-', '+', '[' , ']' };
	private char[] openable = { '+', ']' };
	private HashMap<Character,Character> openTo;

//	private ArrayList<ArrayList<MapElement>> oWorld;
	private HashMap<Coord, MapElement> oWorld;

	public HashMap<Coord, MapElement> getoWorld() {
		return oWorld;
	}


	private HashMap<Coord, Personnage> personnages;
	private HashMap<Coord, Element> elements;
	
	public OldWorld(String file) {
		elements = new HashMap<Coord, Element>();
		personnages = new HashMap<Coord, Personnage>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null;) {
				data.add(line.toCharArray());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		openTo = new HashMap<Character, Character>();
		openTo.put(new Character(']'),new Character('['));
		openTo.put(new Character('+'),new Character('/'));
	}
	
	public boolean isCollidable(Coord coord) {
		boolean isCollidable = false;
		char toCompare = getCharacter(coord);
		
		for (char c : collidable) {
			if (toCompare == c)
				isCollidable = true;
		}
		return isCollidable;
	}
	
	public boolean isOpenable(Coord coord) {
		boolean isOpenable = false;
		char toCompare = getCharacter(coord);
		for (char c : openable) {
			if (toCompare == c)
				isOpenable = true;
			}
		return isOpenable;
	}

	public ArrayList<char[]> getData() {
		return data;
	}
	/*
	 * Character
	 */

	public char getCharacter(Coord coord) {
		return data.get(coord.getY())[coord.getX()];
	}

	public void setCharacter(Coord coord, char c) {
		data.get(coord.getY())[coord.getX()] = c;
	}

	public ArrayList<char[]> getWorld() {
		return data;
	}

	@Override
	public Iterator<char[]> iterator() {
		Iterator<char[]> iWorld = data.iterator();
		return iWorld;
	}

	public int getWidth() {
		int WSize = 0;

		for (char[] c : data) {
			if (c.length > WSize){
				WSize = c.length;
			}
		}

		return WSize;

	}

	public int getHeight() {
		return data.size();
	}
	
	/*  
	 * Personnage
	 */
	public Personnage getPersonnage(Coord coord) {
		return personnages.get(coord);
	}

	public void addPersonnage(Coord coord,  Personnage perso) {
		this.personnages.put(coord, perso);
	}
	
	public void setPersonnages(HashMap<Coord, Personnage> personnages) {
		this.personnages= personnages;
	}
	
	public void removePersonnage(Coord coord) {
		this.personnages.remove(coord);
	}
	
	public HashMap<Coord, Personnage> getAllPersonnages() {
		return personnages;
	}
	
	/* 
	 * Elements 
	 */
	
	public Element getElement(Coord coord){
		return elements.get(coord);
	}
	
	public void setElement(Element element){
		elements.put(element.getPosition(), element);
	}
	
	public void removeElement(Element element){
		elements.remove(element.getPosition());
	}
	
	public void addChest(Chest chest){
		elements.put(chest.getPosition(), chest);
	}
	
	public HashMap<Coord, Element> getAllElements(){
		return elements;
	}

	
	/*
	 * Monster
	 */
	
	public boolean isMonster(Coord coord) {
		boolean isMonster = personnages.containsKey(coord);
		return isMonster;

	}

}
