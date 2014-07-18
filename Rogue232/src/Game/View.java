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
	protected JTextArea textArea;
	private Semaphore semaphore = new Semaphore(0);
	
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

}
