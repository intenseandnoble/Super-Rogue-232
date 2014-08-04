package Game;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class View extends JFrame {

	protected JPanel jPanel, jPanelGauche, jPanelDroite, jPanelBas,
			jPanelMilieu;
	protected JSplitPane splitV;
	JScrollPane jScroll;

	protected JTextField textField;
	protected JTextArea textArea, textDescription;
	protected static JTextArea textAction;
	private Semaphore semaphore = new Semaphore(0);

	public View(int width, int height) {
		setVisible(true);
		setTitle("SuperRogue232 - v0.1");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//TODO: set window centered;
//		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
//		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		setMinimumSize(new Dimension(500, height));
		
		textArea = new JTextArea(height, width);
		textArea.setFont(new Font("monospaced", Font.PLAIN, 12));
		textArea.setEditable(false);

		splitV = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT);

		textField = new JTextField(width);
		textDescription = new JTextArea(2, width );
		textAction = new JTextArea(20, 30);
		textAction.setEditable(false);
		JScrollPane jScrollPane = new JScrollPane(textAction);

		jPanel = new JPanel();

		jPanelGauche = new JPanel();
		jPanelGauche.setLayout(new BorderLayout());
		jPanelGauche.setBorder(new TitledBorder(new EtchedBorder(), "Jeu"));
		jPanelGauche.add(textDescription, BorderLayout.NORTH);
		jPanelGauche.add(textArea, BorderLayout.CENTER);
		jPanelGauche.add(textField, BorderLayout.SOUTH);

		jPanelDroite = new JPanel(new BorderLayout());
		jPanelDroite.setBorder(new TitledBorder(new EtchedBorder(), "Actions"));
		jPanelDroite.add(jScrollPane, BorderLayout.CENTER);

		splitV.setLeftComponent(jPanelGauche);
		splitV.setRightComponent(jPanelDroite);

		jPanel.add(splitV, BorderLayout.CENTER);

		// Le premier chiffre du textArea défini la hauteur et peut être
		// augmenté au besoin.

		// jPanelBas.setBorder(new TitledBorder ( new EtchedBorder (), "Actions"
		// ));
		// jPanelBas.add(jScrollPane, BorderLayout.NORTH);
		// jPanelBas.add(textField, BorderLayout.SOUTH);
		//
		//
		// jPanelHaut.add(textDescription, BorderLayout.NORTH);
		// jPanelHaut.add(textArea, BorderLayout.SOUTH);
		// jPanelHaut.setBorder(new TitledBorder ( new EtchedBorder (), "Main"
		// ));
		//
		// jPanel.add(jPanelBas, BorderLayout.CENTER);
		// jPanel.add(jPanelHaut, BorderLayout.NORTH);
		//

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
		String s = "Life points : " + String.valueOf(vie)
				+ "     Defense points : " + String.valueOf(defense)
				+ "     Attack points : " + String.valueOf(attaque);

		if (vieB > 0) {
			s += "\nBouclier: " + String.valueOf(vieB) + " pts, "
					+ String.valueOf(defB) + " defense";
		}
		textDescription.setText(s);
	}

	public static void updateTextAction(String s) {
		textAction.setText(s);
	}

	public static void appendTextAction(String s) {
		textAction.append(s + "\n");
	}
}
