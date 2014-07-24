package Game;

public class ConcreteObserver implements Observer{
	
	
	
	public ConcreteObserver() {

	}

	@Override
	public void update(String action) {
		View.updateTextAction(action);
	}

}
