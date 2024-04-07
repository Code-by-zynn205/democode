package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;

import modell.MyModel;
import view.MyView;

public class MyController {
    private MyView view;
    private MyModel model;
    private File selectedFile;

    public MyController(MyView view, MyModel model) {
        this.view = view;
        this.model = model;
        this.selectedFile = null;

        view.getBtnLoad().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
                int result = fileChooser.showSaveDialog(view);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    try {
                        model.save(selectedFile, view.getRootNode());
                        JOptionPane.showMessageDialog(view, "Save successful.");
                    } catch (IOException ex) {
                        JOptionPane.showMessageDialog(view, "Save failed: " + ex.getMessage(),
                                "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        view.getBtnSave().addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int result = fileChooser.showOpenDialog(view);
                if (result == JFileChooser.APPROVE_OPTION) {
                    selectedFile = fileChooser.getSelectedFile();
                    DefaultMutableTreeNode rootNode = model.load(selectedFile);
					view.updateTree(rootNode);
					String fileContent = getFileContent(selectedFile);
					view.showFileContent(fileContent);
					JOptionPane.showMessageDialog(view, "Load successful.");
                }
            }
        });
    }

    private String getFileContent(File file) {
        try {
            byte[] bytes = Files.readAllBytes(file.toPath());
            return new String(bytes, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}