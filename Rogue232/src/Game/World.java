package Game;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class World implements Iterable<char[]> {
	ArrayList<char[]> data = new ArrayList<char[]>();
	private char oldChar; // TODO: prob de remplacement de la porte par point

	public World(String file) {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			for (String line; (line = br.readLine()) != null;) {
				data.add(line.toCharArray());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<char[]> getData() {
		return data;
	}

	public char getChar(Coord coord) {
		return data.get(coord.getY())[coord.getX()];
	}

	public void setChar(Coord coord, char c) {
		oldChar = data.get(coord.getY())[coord.getX()];
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
			++WSize;
		}

		return WSize;

	}

	public int getHeight() {
		return data.size();
	}

}
