package Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputManager {
	
	private BufferedReader cin = new BufferedReader(new InputStreamReader(System.in));
	public InputManager() {
	}
	
 	public String getImput(){
		
		String commande = null;
		
		try {
	         commande = cin.readLine();
	      } catch (IOException ioe) {
    	     System.out.println("enter commande");
	      }
			return commande;
		}
 	
}
