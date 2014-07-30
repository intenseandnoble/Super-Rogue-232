package Game;

import java.util.HashMap;
import java.util.Map.Entry;

import Game.Observer.AppendTextObserver;
import Game.Personnages.Element;
import Game.Personnages.Personnage;

public class GraphicEngine {

	private View view;
	private AppendTextObserver co;

	public GraphicEngine(View view) {
		this.view = view;
	}

	public void updateDisplay(OldWorld world, Personnage hero) {
		String s = toStringWorld(world, world.getAllPersonnages(),
				world.getAllElements());
		int vie = hero.getHp();
		int defense = hero.afficheDef();
		int attaque = hero.afficheAtk();
		int vieB = hero.getShield().getHp();
		int defB = hero.getShield().getDefense();

		view.updateTextArea(s);
		view.updateTextDescription(vie, defense, attaque, vieB, defB);
	}

	// Il y a les monstres et le hero dans le HashMap<Coord,Personnage> monsters
	private String toStringWorld(OldWorld world,
			HashMap<Coord, Personnage> personnages,
			HashMap<Coord, Element> elements) {

		HashMap<Coord, Character> tmp = new HashMap<Coord, Character>();

		for (Entry<Coord, Personnage> entry : personnages.entrySet()) {
			tmp.put(entry.getKey(), world.getCharacter(entry.getKey()));
		}

		for (Entry<Coord, Personnage> entry : personnages.entrySet()) {
			world.setCharacter(entry.getKey(), entry.getValue().getSymbol());
		}

		// need to check
		for (Entry<Coord, Element> entry : elements.entrySet()) {
			world.setCharacter(entry.getKey(), entry.getValue().getSymbol());
		}

		// Create world
		String worldString = "";
		for (char[] str : world) {
			worldString += new String(str)
					+ System.getProperty("line.separator");
		}

		// Add Character in the world
		for (Entry<Coord, Character> entry : tmp.entrySet()) {
			world.setCharacter(entry.getKey(), entry.getValue());
		}

		// Add Item in the world

		return worldString;
	}
}
