package ui;
import ui.SetupPanel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class ViewPanel extends JPanel implements ActionListener {
	
	private static final boolean String = false;
	JLabel l1,l2; 
	JButton b1;
	JTree tree;
    DefaultTreeModel treeModel;
    DefaultMutableTreeNode root; 
    SwingUIFrame frame;
    
    
    
	public  ViewPanel(SwingUIFrame frame) {		
		
    	this.frame = frame;
    	l1=new JLabel("Tree view Panel");
		l1.setBounds(20,20,20,10);
		b1=new JButton("ViewTree");  
 	    b1.setBounds(50,50,90,50); 
 	    b1.addActionListener((ActionListener) this);
 	    l2=new JLabel();
 	    l2.setBounds(50,180,200,30);
 	    root = new DefaultMutableTreeNode("Root");   
 	    add(l1);add(l2);
	    add(b1);
	    
            
 	   	    
	}
	
    protected File[] getListFiles(String Path) {
        File file = new File(Path);
        return file.listFiles();
    }

    private void addChilds(DefaultMutableTreeNode rootNode, String path) {
        File[] files = this.getListFiles(path);
        for(File file:files) {
            if(file.isDirectory()) {
                DefaultMutableTreeNode subDirectory = new DefaultMutableTreeNode(file.getName());
                addChilds(subDirectory, file.getAbsolutePath());
                rootNode.add(subDirectory);
            } else {
                rootNode.add(new DefaultMutableTreeNode(file.getName()));
                
                
            }
        }
    }


	@Override
	public void actionPerformed(ActionEvent E) {
		if (E.getSource() == b1) {
 			l2.setText("ROOT_Path :" + this.frame.setupPanel.rootDirectory);
 			
 			addChilds(root, this.frame.setupPanel.rootDirectory);
 	        treeModel = new DefaultTreeModel(root); 	                
 	        tree = new JTree(treeModel); 	        
 	        add(tree);
 	        
 	       
 	        
 	        
 	        
	}
		
	}
	
}