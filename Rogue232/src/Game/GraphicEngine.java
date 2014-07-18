package Game;

public class GraphicEngine{
	
	private View view;
	
	public GraphicEngine(View view){
		this.view = view;
	}
	
	public void updateDisplay(World world, Character hero){
		String s = toStringWorld(world, hero);
		view.updateTextArea(s);
	}
	
	private String toStringWorld(World world, Character hero){
		
		char posHeroChar = world.getChar(hero.getPosition());
		world.setChar(hero.getPosition(), hero.getSymbol());
		
		String worldString = "";
		for(char[] str : world){
			worldString += new String(str) + System.getProperty("line.separator");
		}
		
		world.setChar(hero.getPosition(), posHeroChar);
		return worldString;
	}
}
