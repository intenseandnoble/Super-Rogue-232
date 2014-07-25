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

//renomer world plus tard
public class WorldObject implements Iterable<ArrayList<MapElement>> {
	private ArrayList<ArrayList<Symbol>> data;
	//changer nom plus tard et decoupler en sa propre classe(similaire a l'ancient world)
	private ArrayList<char[]> sdata ;

	public WorldObject(String file) {
		//instanciation de la matrice de mapElement
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null && line != "%";) {
				ArrayList<MapElement> temp = new ArrayList<MapElement>();
				for (char c : line.toCharArray()){
					switch (c) {
					case '-': temp.add(new Wall('-')); break;
					case '|': temp.add(new Wall('|')); break;
					case '+': temp.add(new Door(false)); break;
					case '/': temp.add(new Door(true)); break;
					case ',': temp.add(new Floor()); break;
					}
				data.add(temp);
				}
			}
			//ajout des Elements
			for (String line; (line = br.readLine()) != null;){
				String[] tokens = line.split(";");
				Element monElement;//TODO: faire classe Element
				Coord pos = new Coord(Integer.parseInt(tokens[0]), Integer.parseInt(tokens[1]));
				switch(tokens[2]){
					//a remplacer par calls à ElementFactory quand elle existera
					case "a": monElement = PersonnageFactory.createMonster(pos); break;
					case "1": monElement = new Chest( new Shield("Dacamole épique de l'Enfer", 40, 10)); break;
				}
				monElement.setPosition(pos);
				this.get(pos).putElement(monElement);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		//Creation de la matrice de char
		sdata = new ArrayList<char[]>();
		for (ArrayList<MapElement> row : this){
			String temp = "";
			for (MapElement mEle : row){
				temp += mEle.getMapElement();
			}
		sdata.add(temp.toCharArray());
		}
	}

	public MapElement get(Coord coord) {
		return data.get(coord.getY()).get(coord.getX());
	}

	public void put(Coord coord, Symbol symbol) {
		data.get(coord.getY()).set(coord.getX(), symbol);
	}

	public int getWidth() {
		int WSize = 0;
		for (ArrayList<Symbol> c : data) {
			WSize = Math.max(c.size(), WSize);
		}
		return WSize;

	}

	public int getHeight() {
		return data.size();
	}

	@Override
	public Iterator<ArrayList<Symbol>> iterator() {
		return data.iterator();
	}

}
