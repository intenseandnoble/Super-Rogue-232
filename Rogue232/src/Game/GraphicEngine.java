package Game;

import java.util.HashMap;
import java.util.Map.Entry;

import Game.Observer.ConcreteObserver;

public class GraphicEngine {

	private View view;
	private ConcreteObserver co;
	
	
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

		String posMonsterChar = new String();

		for (Entry<Coord, Personnage> entry : monsters.entrySet()) {
			posMonsterChar += world.getChar(entry.getKey());
		}

		for (Entry<Coord, Personnage> entry : monsters.entrySet()) {
			world.setChar(entry.getKey(), entry.getValue().getSymbol());
		}

		String worldString = "";
		for (char[] str : world) {
			worldString += new String(str)
					+ System.getProperty("line.separator");
		}

		for (Entry<Coord, Personnage> entry : monsters.entrySet()) {
			for (int i = 0; i < posMonsterChar.length(); i++)
				world.setChar(entry.getKey(), posMonsterChar.charAt(i));
		}

		return worldString;
	}
}
