package Game;

public class Game {
	
	private boolean running = false;
	private View view;
	private GraphicEngine ge;
	private InputManager im;
	private World world;
	private String command;
	private char[] Collidable = {'|',' ','-','+'};
	private char[] openable = {'+'};
	private Character hero;
	
	public Game()
	{
		
		
		// afficher l'information relative au jeu
		running = true;

		world = new World("maps/bigWorld.txt");
		hero = new Character( new Coord(2, 2), '@', 5);
		
		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);
		
	}
	
	public Game(String file)
	{
		// afficher l'information relative au jeu
		running = true;

		world = new World(file);
		hero = new Character( new Coord(2, 2), '@', 5);
		
		view = new View(world.getWidth(), world.getHeight());
		ge = new GraphicEngine(view);
		im = new InputManager(view);
		
	}
	
	public void mainLoop () {
		
		// game loop
		while (running){
			
			updateDisplay();
			command= im.getInput();
			executeCommand();
		}
		
	}
	
	private void executeCommand()
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
		case "open up":
			open(hero,new Coord(0, -1));
			break;
		case "open down":
			open(hero,new Coord(0, 1));
			break;
		case "open left":
			open(hero,new Coord(-1, 0));
			break;
		case "open right":
			open(hero,new Coord(1, 0));
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
	
	public void move(Character character,Coord coord){
		//TODO: changer test pour mettre private
		Coord newPosCharacter = character.getPosition().add(coord);
		if(!isCollidable(newPosCharacter)){
			character.setPosition(newPosCharacter);
		}
	}
	
	
	public void open(Character character, Coord coord){
		//TODO: changer test pour mettre private
		//ouvre seulement les portes
		Coord newPos = character.getPosition().add(coord);
		if(isOpenable(newPos)){
			world.setChar(newPos, '/');
		}
	}
	
	private boolean isCollidable(Coord coord){
		boolean isCollidable = false;
		char toCompare = world.getChar(coord);
		//char[][] dataWold = wold.getWold();
		//char toCompare = dataWold[coord.getX()][coord.getY()];
		for(char c : Collidable){
			if(toCompare == c)
				{
					isCollidable = true;
				}
		}
		
		return isCollidable;
	}
	
	private boolean isOpenable(Coord coord){
		boolean isOpenable = false;
		char toCompare = world.getChar(coord);
		//char[][] dataWold = wold.getWold();
		//char toCompare = dataWold[coord.getX()][coord.getY()];
		for(char c : openable){
			if(toCompare == c)
				{
					isOpenable = true;
				}
		}
		
		return isOpenable;
	}
	
	private void updateDisplay(){
		ge.updateDisplay(world, hero);
	}
	
	public World getWorld(){
		return world;
	}
	
	public GraphicEngine getGe(){
		return ge;
	}
	
	public InputManager getIm() {
		return im;
	}
	
	public Character getHero() {
		return hero;
	}
	
}
