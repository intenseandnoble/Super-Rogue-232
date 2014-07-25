package Game;

import java.util.HashMap;
import java.util.Map.Entry;

import Game.Observer.AppendTextObserver;
import Game.Personnages.Personnage;

public class GraphicEngine {

	private View view;
	private AppendTextObserver co;
	
	
	public GraphicEngine(View view) {
		this.view = view;
	}

	public void updateDisplay(World world, HashMap<Coord, Personnage> monsters, Personnage hero) {
		String s = toStringWorld(world, monsters);
		int vie = hero.getHp();
		int defense = hero.afficheDef();
		int attaque = hero.afficheAtk();
		int vieB = hero.getShield().getHp();
		int defB = hero.getShield().getDefense();
		
		view.updateTextArea(s);
		view.updateTextDescription(vie, defense, attaque, vieB, defB);
	}

	// Il y a les monstres et le hero dans le HashMap<Coord,Personnage> monsters
	private String toStringWorld(World world,
			HashMap<Coord, Personnage> monsters) {

		HashMap<Coord, Character> tmp = new HashMap<Coord, Character>();
		
		for (Entry<Coord, Personnage> entry : monsters.entrySet()) {
			tmp.put(entry.getKey(), world.getChar(entry.getKey()));
		}

		for (Entry<Coord, Personnage> entry : monsters.entrySet()) {
			world.setChar(entry.getKey(), entry.getValue().getSymbol());
		}

		String worldString = "";
		for (char[] str : world) {
			worldString += new String(str)
					+ System.getProperty("line.separator");
		}

		for (Entry<Coord, Character> entry : tmp.entrySet()){
			world.setChar(entry.getKey(), entry.getValue());
		}
		
		return worldString;
	}
}
