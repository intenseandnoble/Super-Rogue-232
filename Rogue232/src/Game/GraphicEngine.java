package Game;

public class GraphicEngine{
	private String worldString;
	
	public void updateDisplay(World world, Character hero){
		toStringWorld(world, hero);
		clearConsole();
		System.out.println(worldString);
	}
	
	private void clearConsole(){
		try
		{
			final String os = System.getProperty("os.name");
			if (os.contains("Windows")){
				Runtime.getRuntime().exec("cls");
			} else {
				Runtime.getRuntime().exec("clear");
			}
		}
		catch (final Exception e){
			;
		}
	}
	
	private void toStringWorld(World world, Character hero){
		
		char posHeroChar = world.getChar(hero.getPosition());
		world.setChar(hero.getPosition(), hero.getSymbol());
		
		worldString = "";
		for(char[] str : world){
			worldString += new String(str) + System.getProperty("line.separator");
		}
		
		world.setChar(hero.getPosition(), posHeroChar);
	}
}
