package Game;

public class GraphicEngine{
	private String woldString;
	
	public void updateDisplay(Wold wold, Character hero){
		toStringWold(wold, hero);
		ClearDisplay();
		System.out.println(woldString);
	}
	
	private void toStringWold(Wold wold, Character hero){
		char[][] currentWold = wold.getWold();
		Coord posHero = hero.getPosition();
		
		char posHeroChar = currentWold[posHero.getY()][posHero.getX()];
		currentWold[posHero.getY()][posHero.getX()] = hero.getSymbol();
		
		woldString = "";
		for(char[] str : currentWold){
			woldString += new String(str) + System.getProperty("line.separator");
		}
		currentWold[posHero.getY()][posHero.getX()] = posHeroChar;
	}
	
	private void ClearDisplay()
	{
		try
	    {
	        final String os = System.getProperty("os.name");

	        if (os.contains("Windows"))
	        {
	            Runtime.getRuntime().exec("cls");
	        }
	        else
	        {
	            Runtime.getRuntime().exec("clear");
	        }
	    }
	    catch (final Exception e)
	    {
	        //  Handle any exceptions.
	    }

	}
}
