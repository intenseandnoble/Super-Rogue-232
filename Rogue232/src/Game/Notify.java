package Game;

public class Notify {

	 /* Observateurs */
	static ConcreteObserver observer = new ConcreteObserver();
	
	static void notifyChange(String action) 
	{
		observer.update(action);
	}
	
}
