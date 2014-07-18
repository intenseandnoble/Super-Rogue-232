package Game;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class View extends JFrame{

	protected JPanel jPanel;
	protected JTextField textField;
	protected JTextArea textArea;
	
	public View(int width, int height){
		setVisible(true);
		jPanel = new JPanel(new BorderLayout());
		textField = new JTextField(width);
		textArea = new JTextArea(height, width);
		textArea.setFont(new Font ("monospaced", Font.PLAIN, 12));
		jPanel.add(textArea, BorderLayout.CENTER);
		jPanel.add(textField, BorderLayout.SOUTH);
		setLayout(new BorderLayout());
		add(jPanel, BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
	}
	
	public String getCommand(){
		return textField.getText();
	}
	
	
	public void updateTextArea(String s){
		textArea.setText(s);
	}

}
