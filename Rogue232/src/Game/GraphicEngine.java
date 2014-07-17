package Game;

public class GraphicEngine{
	
	public void updateDisplay(World world, Character hero){
		String s = toStringWorld(world, hero);
		clearConsole();
		System.out.println(s);
	}
	
	private void clearConsole(){
		//note: c'est la seule facon portable de le faire en java
		for (int i = 0; i < 50; ++i) System.out.println();
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
