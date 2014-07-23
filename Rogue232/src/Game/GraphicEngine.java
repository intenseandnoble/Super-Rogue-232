package Game;

import java.util.HashMap;
import java.util.Map.Entry;

public class GraphicEngine {

	private View view;

	public GraphicEngine(View view) {
		this.view = view;
	}

	public void updateDisplay(World world, HashMap<Coord,Personnage> monsters) {
		String s = toStringWorld(world, monsters);
		view.updateTextArea(s);
	}

	private String toStringWorld(World world, HashMap<Coord,Personnage> monsters){
		
		String posMonsterChar = new String();
		
		for (Entry<Coord, Personnage> entry: monsters.entrySet()){
			posMonsterChar += world.getChar(entry.getKey());	
		}
		
		for (Entry<Coord, Personnage> entry: monsters.entrySet()){
			world.setChar(entry.getKey(), entry.getValue().getSymbol());
		}
		
		String worldString = "";
		for(char[] str : world){
			worldString += new String(str) + System.getProperty("line.separator");
		}
		
		for (Entry<Coord, Personnage> entry: monsters.entrySet()){
			for(int i=0; i < posMonsterChar.length(); i++)
				world.setChar(entry.getKey(), posMonsterChar.charAt(i));	
		}
		
		return worldString;
	}
}
