package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {
	
	private View view;
	
	public InputManager(View view){
		this.view = view;
	}

	public String getInput(){
		return view.getCommand();
		}
 	
}
