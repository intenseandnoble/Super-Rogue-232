package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Game.Items.*;
import Game.MapElements.*;
import Game.Personnages.*;

//renomer world plus tard
public class World implements Iterable<ArrayList<MapElement>> {
	private ArrayList<ArrayList<MapElement>> data;
	// changer nom plus tard et decoupler en sa propre classe(similaire a
	// l'ancient world)
	private ArrayList<char[]> sdata;

	public World(String file) {
		// instanciation de la matrice de mapElement
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null && line != "%";) {
				ArrayList<MapElement> arrayMapElement = new ArrayList<MapElement>();
				for (char c : line.toCharArray()) {
					arrayMapElement.add(MapElementFactory.createMapElement(c));
				}
				 data.add(arrayMapElement);
			}
			// ajout des Elements
			for (String line; (line = br.readLine()) != null;) {
				String[] tokens = line.split(";");
				Element monElement = null;// TODO: Faire de quoi pour éviter des
											// NullException
				Coord pos = new Coord(Integer.parseInt(tokens[0]),
						Integer.parseInt(tokens[1]));
				
				monElement = ElementFactory.create(tokens[2],pos);
	
				monElement.setPosition(pos);
				if(this.get(pos) instanceof Floor){
					((Floor)this.get(pos)).putElement(monElement);
				}
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Creation de la matrice de char
		sdata = new ArrayList<char[]>();
		for (ArrayList<MapElement> row : this) {
			String temp = "";
			for (MapElement mEle : row) {
				temp += mEle.getSymbol();
			}
			sdata.add(temp.toCharArray());
		}
	}

	public MapElement get(Coord coord) {
		return data.get(coord.getY()).get(coord.getX());
	}

	public void put(Coord coord, MapElement symbol) {
		data.get(coord.getY()).set(coord.getX(), symbol);
	}

	public int getWidth() {
		int WSize = 0;
		for (ArrayList<MapElement> c : data) {
			WSize = Math.max(c.size(), WSize);
		}
		return WSize;

	}

	public int getHeight() {
		return data.size();
	}

	@Override
	public Iterator<ArrayList<MapElement>> iterator() {
		return data.iterator();
	}

	public static void swapMapElement(MapElement a, MapElement b){
		MapElement tempA = a.clone();
		a=b;
		b=tempA;
	}
}
