package Game;

public class Wold {
	char[][] data;
	
	public Wold()
	{
		char[] array =  {'|','-','-','-','|'};
		char[] array1 = {'|','.','.','.','|'};
		char[] array2 = {'|','.','.','.','|'};
		char[] array3 = {'|','.','.','.','|'};
		char[] array4 = {'|','-','-','-','|'};
		
		data = new char[][]{ array , array1 , array2, array3, array4};

		
	}
	
	public char getChar(Coord coord){
		return data[coord.getY()][coord.getX()];
	}
	
	public char[][] getWold()
	{
		return data;
	}
	
	public void LoadMap()
	{
		
	}
}
