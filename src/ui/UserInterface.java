package ui;

import javax.swing.*;

import execute.Executioner;
import setup.Initiator;

import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;  
public class UserInterface implements ActionListener{  
	JLabel l1,l2,l3,l4,l5;  
	JTextArea area;  
	JButton b1,b2,b3; 
	JFrame f= new JFrame();
	
	String rootDirectory;
	public UserInterface() {  	      
	    l1=new JLabel();  
	    l1.setBounds(50,200,200,50);  
	    l2=new JLabel();  
	    l2.setBounds(160,25,100,30);
	    l3=new JLabel();  
	    l3.setBounds(160,25,100,30);
	    l4=new JLabel();  
	    l4.setBounds(50,25,200,30);
	    area=new JTextArea();
	    l5=new JLabel("Enter Folder Path");
	    l5.setBounds(50,70,100,30);
	    area=new JTextArea("E:\\Root");
	    area.setBounds(50,100, 200,20);  
	    b1=new JButton("Setup");  
	    b1.setBounds(50,150,70,30);  
	    b1.addActionListener(this);  
	    b2=new JButton("Execute");  
	    b2.setBounds(100,180,80,30);  
	    b2.addActionListener(this);
	    b3=new JButton("ViewTree");  
	    b3.setBounds(150,150,90,30);  
	    b3.addActionListener(this);
	    f.add(l1);f.add(l2);f.add(l3);f.add(l4);f.add(l5);f.add(area);f.add(b1);f.add(b2);f.add(b3); 
	    f.setSize(300,300);  
	    f.setLayout(null);  
	    f.setVisible(true);  
	}  
	
	public void actionPerformed(ActionEvent E){ 
		if (E.getSource() == b1) {		       
		     rootDirectory=area.getText();
		   File  file = new File(rootDirectory);
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
			f.setVisible(false);
			f.dispose();
		}
		
		
	}
	
	
	public static void main(String[] args) {  
	    new UserInterface();  
	 }   
} 


