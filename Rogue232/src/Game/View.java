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

public class View extends JFrame {

	protected JPanel jPanel, jPanelHaut, jPanelBas;
	
	protected JTextField textField;
	protected JTextArea textArea, textDescription;
	protected static JTextArea textAction;
	private Semaphore semaphore = new Semaphore(0);

	public View(int width, int height) {
		setVisible(true);
		jPanel = new JPanel(new BorderLayout());
		jPanelBas = new JPanel(new BorderLayout());
		jPanelHaut = new JPanel(new BorderLayout());
		textField = new JTextField(width);
		textDescription = new JTextArea(2, width);
		textAction = new JTextArea(2, width);
		textArea = new JTextArea(height, width);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
		// Le premier chiffre du textArea défini la hauteur et peut être
		// augmenté au besoin.
		jPanelBas.add(textAction, BorderLayout.NORTH);
		jPanelBas.add(textField, BorderLayout.SOUTH);
		
		jPanelHaut.add(textDescription, BorderLayout.NORTH);
		jPanelHaut.add(textArea, BorderLayout.SOUTH);

		jPanel.add(jPanelBas, BorderLayout.SOUTH);
		jPanel.add(jPanelHaut, BorderLayout.NORTH);



		// Lorsque ASWD sera implémenté, on pourra utiliser le SOUTH pour
		// décrire les évènements (ex. le contenu d'un coffre ouvert)

		setLayout(new BorderLayout());
		add(jPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}

	public String getCommand() {
		textField.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent event) {
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

	public void updateTextArea(String s) {
		textArea.setText(s);
	}

	public void updateTextDescription(int vie, int defense, int attaque,
			int vieB, int defB) {
		String s = "Points de vie: " + String.valueOf(vie)
				+ "     Points de defense: " + String.valueOf(defense)
				+ "     Points d'attaque: " + String.valueOf(attaque);
		
		if (vieB > 0) {
			s += "\nBouclier: " + String.valueOf(vieB) + " pts, "
					+ String.valueOf(defB) + " defense";
		}
		textDescription.setText(s);
	}
	
	public static void updateTextAction(String s) {
		textAction.setText(s);
	}
}
