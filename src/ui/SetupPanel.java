package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import execute.Executioner;
import setup.Initiator;

public class SetupPanel extends JPanel implements ActionListener {

	JLabel l1,l2,l3,l4,l5;  
	JTextArea area;  
	JButton b1,b2,b3; 
	String rootDirectory;
	SwingUIFrame frame;
    public SetupPanel(SwingUIFrame frame)   {
    	this.frame = frame;
    	l1=new JLabel();  
 	    l1.setBounds(50,200,200,50);  
 	    l2=new JLabel();  
 	    l2.setBounds(160,25,100,30);
 	    l3=new JLabel();  
 	    l3.setBounds(160,25,100,30);
 	    l4=new JLabel();  
 	    l4.setBounds(50,180,200,30);
 	    area=new JTextArea();
 	    l5=new JLabel("Enter Folder Path");
 	    l5.setBounds(20,20,100,30);
 	    area=new JTextArea("E:\\Root");
 	    area.setBorder(BorderFactory.createLineBorder(Color.black));
 	    area.setBounds(20,60, 200,20);  
 	    b1=new JButton("Setup");  
 	    b1.setBounds(70,110,70,30);  
 	    b1.addActionListener(this);  
 	    b2=new JButton("Execute");  
 	    b2.setBounds(100,180,80,30);  
 	    b2.addActionListener(this);
 	    b3=new JButton("ViewTree");  
 	    b3.setBounds(150,150,90,30);  
 	    b3.addActionListener((ActionListener) this);
 	    add(l1);add(l2);add(l3);add(l4);add(l5);add(area);add(b1);//add(b2);add(b3); 
 	    setSize(300,300);  
 	    setLayout(null);  
 	    setVisible(true);  
 	}  
 	
 	public void actionPerformed(ActionEvent E){ 
 		if (E.getSource() == b1) {	
 			JFrame f= new JFrame("Confirmation");
 		     rootDirectory=area.getText();
 		    File file = new File(rootDirectory);
 		    l1.setText("Folder Path: "+ rootDirectory);
 		    int result = JOptionPane.showConfirmDialog(f,"Do you want to Proceed with Folder creation? ","Test",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
 		      if(result == JOptionPane.YES_OPTION){
 		    	  if (!file.exists()) {		    		    
 		    		   Initiator i = new Initiator(rootDirectory);
 		    	    	try {
 							i.setupDir();
 						} catch (IOException e1) {
 							// TODO Auto-generated catch block
 							e1.printStackTrace();
 						}
 		                l4.setText("Directory Created Sucessfully");
 	
 		                } 
 		    	  else {
 		                	l4.setText("Directory Already Exist");
 		                	
 		                }
 		            }
 		      else 
 		    	  if (result == JOptionPane.NO_OPTION){
 		               l3.setText("Re-Enter Path ");
 		            }
 		    	  else {
 		               
 		            }
 		        }
 		
 		    b3.addActionListener(new ActionListener() {			
 			@Override
 			public void actionPerformed(ActionEvent e) {
 				//SwingUtilities.invokeLater(new TreeStructure(this));
 				
 								
 			}
 		});
 		 
 		 
 		
 		
 		if (E.getSource() == b2) {
 			l4.setText("Execute button Clicked");
 			Executioner e = new Executioner(rootDirectory);
 	    	try {
 				e.execute();
 			} catch (Exception e1) {
 				// TODO Auto-generated catch block
 				e1.printStackTrace();
 			}
 			
 		}
 		
 		
 	}
   
 	
 
} 