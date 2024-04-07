package view;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import controller.MyController;
import modell.MyModel;

public class MyView extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JScrollPane treeScrollPane;
    private JButton btnSave;
    private JButton btnLoad;
    private DefaultMutableTreeNode rootNode;
    private JLabel lblSelectedFile;
    private JTextArea txtFileContent;

    private MyController controller;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MyView frame = new MyView();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MyView() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 650, 409);
        contentPane = new JPanel();
        setContentPane(contentPane);
        contentPane.setLayout(null);

        btnSave = new JButton("LOAD");
        btnSave.setBounds(411, 312, 89, 23);
        contentPane.add(btnSave);

        btnLoad = new JButton("SAVE");
        btnLoad.setBounds(217, 312, 89, 23);
        contentPane.add(btnLoad);

        treeScrollPane = new JScrollPane();
        treeScrollPane.setBounds(10, 11, 86, 349);
        contentPane.add(treeScrollPane);

        JTree tree = new JTree();
        treeScrollPane.setViewportView(tree);

        lblSelectedFile = new JLabel("");
        lblSelectedFile.setBounds(205, 11, 419, 23);
        contentPane.add(lblSelectedFile);

        JScrollPane fileScrollPane = new JScrollPane();
        fileScrollPane.setBounds(120, 11, 504, 261);
        contentPane.add(fileScrollPane);

        txtFileContent = new JTextArea();
        fileScrollPane.setViewportView(txtFileContent);

        controller = new MyController(this, new MyModel());

        tree.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    TreePath path = tree.getPathForLocation(e.getX(), e.getY());
                    if (path != null) {
                        DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) path.getLastPathComponent();
                        if (selectedNode.isLeaf()) {
                            String filePath = getFilePath(selectedNode);
                            lblSelectedFile.setText("Selected File: " + filePath);
                        }
                    }
                }
            }
        });
    }

    public JButton getBtnSave() {
        return btnSave;
    }

    public JButton getBtnLoad() {
        return btnLoad;
    }

    public DefaultMutableTreeNode getRootNode() {
        return rootNode;
    }

    public void updateTree(DefaultMutableTreeNode rootNode) {
        this.rootNode = rootNode;
        JTree tree = new JTree(rootNode);
        treeScrollPane.setViewportView(tree);
    }

    public void showFileContent(String content) {
        txtFileContent.setText(content);
    }

    private String getFilePath(DefaultMutableTreeNode node) {
        String filePath = "";
        DefaultMutableTreeNode parent = (DefaultMutableTreeNode) node.getParent();
        while (parent != null) {
            filePath = parent.getUserObject().toString() + "/" + filePath;
            parent = (DefaultMutableTreeNode) parent.getParent();
        }
        filePath += node.getUserObject().toString();
        return filePath;
    }
}