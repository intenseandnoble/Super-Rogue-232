package Game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{

	protected JPanel jPanel;
	protected JTextField textField;
	protected JTextArea textArea, textDescription;
	private Semaphore semaphore = new Semaphore(0);
	
	public View(int width, int height){
		setVisible(true);
		jPanel = new JPanel(new BorderLayout());
		textField = new JTextField(width);
		// Le premier chiffre du textArea défini la hauteur et peut être augmenté au besoin.
		textDescription = new JTextArea(5, 9);
		textArea = new JTextArea(height, width);
		textArea.setFont(new Font ("monospaced", Font.PLAIN, 12));
		jPanel.add(textArea, BorderLayout.NORTH);
		jPanel.add(textDescription, BorderLayout.CENTER);
		//Lorsque ASWD sera implémenté, on pourra utiliser le SOUTH pour décrire les évènements (ex. le contenu d'un coffre ouvert)
		jPanel.add(textField, BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		add(jPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	public String getCommand(){
		textField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent event){
            	semaphore.release();
            }
        });
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String command = textField.getText();
		textField.setText("");
		return command;
	}
	
	
	public void updateTextArea(String s){
		textArea.setText(s);
	}
	
	public void updateTextDescription(int vie, int defense, int attaque){
		String s = "Points de vie: "+ String.valueOf(vie) + "\nPoints de defense: " + String.valueOf(defense) + "\nPoints d'attaque: " + String.valueOf(attaque)  ;
		textDescription.setText(s);
	}

}
