package ui;

import java.awt.BorderLayout;
import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class TestTree extends JFrame {

    JTree tree;
    DefaultTreeModel treeModel;

    public TestTree() {
        super("Tree Test Example");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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

    public void init() {
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("Root");

        addChilds(root, "C:\\Root");

        treeModel = new DefaultTreeModel(root);
        tree = new JTree(treeModel);

        getRootPane().add(tree, BorderLayout.CENTER);
    }

   
}
