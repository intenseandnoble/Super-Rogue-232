package Game;
import java.lang.Integer;

public class Coord {
	private int x;
	private int y;
	public Coord()
	{
		x = 0;
		y= 0;
	}
	
	public Coord(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setXY(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	public Coord add(Coord coord){
		return new Coord(this.x + coord.x, this.y + coord.y);
	}
	
	public Coord subtract(Coord coord){
		return new Coord(this.x - coord.x,this.y - coord.y);
	}
	public Coord IAdd(Coord coord){
		this.x += coord.x;
		this.y += coord.y;
		return this;
	}
	
	@Override
	public String toString(){
		return "(" + Integer.toString(x) + "," + Integer.toString(y) + ")";
	}
	
	public Boolean equals(Coord coord){
		return coord.getX() == x && coord.getY() == y;
	}
}
