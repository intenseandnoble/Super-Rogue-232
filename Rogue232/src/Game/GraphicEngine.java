package Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import Game.MapElements.MapElement;
import Game.Observer.AppendTextObserver;
import Game.Personnages.Element;
import Game.Personnages.Personnage;

public class GraphicEngine {

	private View view;
	private AppendTextObserver co;

	public GraphicEngine(View view) {
		this.view = view;
	}

	public void updateDisplay(World world, Personnage hero) {
		String s = toStringWorld(world);
		int vie = hero.getHp();
		int defense = hero.afficheDef();
		int attaque = hero.afficheAtk();
		int vieB = hero.getShield().getHp();
		int defB = hero.getShield().getDefense();

		view.updateTextArea(s);
		view.updateTextDescription(vie, defense, attaque, vieB, defB);
	}

	private String toStringWorld(World world){
		String worldString = "";
		for (ArrayList<MapElement> row: world){
			String rowString = "";
			for (MapElement me : row){
				 rowString += me.getSymbol();
			}
			worldString += rowString + "\n";
		}
		return worldString;
		
	}
}
