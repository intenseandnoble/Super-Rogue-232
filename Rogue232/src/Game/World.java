package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import Game.MapElements.Floor;
import Game.MapElements.MapElement;
import Game.MapElements.MapElementFactory;
import Game.Personnages.Element;
import Game.Personnages.ElementFactory;

public class World implements Iterable<ArrayList<MapElement>> {
	private ArrayList<ArrayList<MapElement>> data;

	public World(String file) {
		data = new ArrayList<ArrayList<MapElement>>();
		// instanciation de la matrice de mapElement
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null
					&& !line.contains("%");) {
				ArrayList<MapElement> arrayMapElement = new ArrayList<MapElement>();
				for (char c : line.toCharArray()) {
					arrayMapElement.add(MapElementFactory.createMapElement(c));
				}
				data.add(arrayMapElement);
			}
			// ajout des Elements
			for (String line; (line = br.readLine()) != null;) {
				String[] tokens = line.split(";");
				Element monElement = null;// TODO: Faire de quoi pour �viter des
											// NullException
				Coord pos = new Coord(Integer.parseInt(tokens[0]),
						Integer.parseInt(tokens[1]));

				monElement = ElementFactory.create(tokens[2], pos);

				monElement.setPosition(pos);
				if (this.get(pos) instanceof Floor) {
					((Floor) this.get(pos)).putElement(monElement);
				}

			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void swapMapElement(MapElement a, MapElement b) {
		MapElement tempA = a.clone();
		a = b;
		b = tempA;
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

	public ArrayList<ArrayList<MapElement>> getData() {
		return data;
	}

	@Override
	public Iterator<ArrayList<MapElement>> iterator() {
		return data.iterator();
	}

}
