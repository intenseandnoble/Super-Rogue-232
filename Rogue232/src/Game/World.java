package Game;

import java.io.BufferedReader;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import Game.Items.Chest;
import Game.Items.Shield;
import Symbol.Symbol;
import Symbol.Wall;
import Symbol.Floor;
import Symbol.Door;

public class World implements Iterable<char[]> {
	ArrayList<char[]> data = new ArrayList<char[]>();
	private char[] collidable = { '|', ' ', '-', '+', '[' , ']' };
	private char[] openable = { '+', ']' };
	private HashMap<Character,Character> openTo;
	private ArrayList<ArrayList<Symbol>> oWorld;

	public World(String file) {
		/*
		//TODO: instantiation de la map avec des objects
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null && line != "%";) {
				ArrayList<Symbol> temp = new ArrayList<Symbol>();
				for (char c : line.toCharArray()){
					switch (c) {
					case '-': temp.add(new Wall('-')); break;
					case '|': temp.add(new Wall('|')); break;
					case '+': temp.add(new Door(false)); break;
					case '/': temp.add(new Door(true)); break;
					case ',': temp.add(new Floor()); break;
					}
				oWorld.add(temp);
				}
			}
			for (String line; (line = br.readLine()) != null;){
				String[] tokens = line.split(';');
				switch(tokens[2]){
				//TODO
				}
				monElement.setPosition(new Coord(tokens[0], tokens[1]));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
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
		char toCompare = getChar(coord);
		
		for (char c : collidable) {
			if (toCompare == c)
				isCollidable = true;
		}
		return isCollidable;
	}
	
	public boolean isOpenable(Coord coord) {
		boolean isOpenable = false;
		char toCompare = getChar(coord);
		for (char c : openable) {
			if (toCompare == c)
				isOpenable = true;
			}
		return isOpenable;
	}

	public ArrayList<char[]> getData() {
		return data;
	}

	public char getChar(Coord coord) {
		return data.get(coord.getY())[coord.getX()];
	}

	public void setChar(Coord coord, char c) {
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

}
