package Game.Observer;

import Game.View;

public class ConcreteObserver implements Observer{
	
	
	
	public ConcreteObserver() {

	}

	@Override
	public void update(String action) {
		View.appendTextAction(action);
	}

}
