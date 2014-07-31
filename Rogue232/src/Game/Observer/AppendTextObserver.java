package Game.Observer;

import Game.View;

public class AppendTextObserver implements Observer {

	public AppendTextObserver() {
	}

	@Override
	public void update(String action) {
		View.appendTextAction(action);
	}

}
