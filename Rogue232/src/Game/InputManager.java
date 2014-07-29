package Game;

public class InputManager {

	private View view;

	public InputManager(View view) {
		this.view = view;
	}

	public String getInput() {
		return view.getCommand();
	}

}
