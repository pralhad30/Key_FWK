package ui;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public class SwingUIFrame extends JFrame {
	
	SetupPanel setupPanel;
	ViewPanel viewPanel;
	public SwingUIFrame() {
	
	setLayout(null);
    setBounds(400, 200, 800, 500);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	
	setupPanel = new SetupPanel(this);
	setupPanel.setBounds(100,100,250,250);
	setupPanel.setBackground(Color.WHITE);
	viewPanel = new ViewPanel(this);
	viewPanel.setBounds(400,100,250,250);
	viewPanel.setBackground(Color.lightGray);
	
	
	
	add(setupPanel);add(viewPanel);
	setVisible(true);	
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	
	}
	


public static void main(String[] args) {  
    new SwingUIFrame();  
 }   
} 
