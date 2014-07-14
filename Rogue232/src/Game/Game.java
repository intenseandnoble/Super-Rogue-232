package Game;

import java.awt.Container;
import java.util.Set;

public class Game {
	
	private boolean running = false;
	
	private static final GraphicEngine ge = new GraphicEngine();
	private Wold wold;
	private String command;
	private char[] Collidable = {'|',' ','-'};
	private Character hero;
	
	public Game()
	{
		InputManager im = new InputManager();
		// afficher l'information relative au jeu
		running = true;

		wold = new Wold();
		hero = new Character( new Coord(2, 2), '@');
		
		// game loop
		while (running){
			
			updateDisplay();
			command= im.getImput();
			ExecuteCommand();
		}
	}
	
	private void ExecuteCommand()
	{
		switch (command.toLowerCase()) {
		case "up":
			move(hero,new Coord(0, -1));
			break;
		case "down":
			move(hero,new Coord(0, 1));
			break;
		case "left":
			move(hero,new Coord(-1, 0));
			break;
		case "right":
			move(hero,new Coord(1, 0));
			break;
		case "exit":
			System.exit(0);
			break;
		case "help":
			break;

		default:
			break;
		}
	}
	
	private void move(Character character,Coord coord){
		Coord newPosCharacter = character.getPosition().add(coord);
		if(!isCollidable(newPosCharacter)){
			character.setPosition(newPosCharacter);
		}
	}
	
	private boolean isCollidable(Coord coord){
		boolean isCollidable = false;
		char toCompare = wold.getChar(coord);
		//char[][] dataWold = wold.getWold();
		//char toCompare = dataWold[coord.getX()][coord.getY()];
		for(int i=0; i < Collidable.length; ++i){
			if(toCompare == Collidable[i])
				{
					isCollidable = true;
				}
		}
		
		return isCollidable;
	}
	
	private void updateDisplay(){
		ge.updateDisplay(wold, hero);
	}
	
	
}
