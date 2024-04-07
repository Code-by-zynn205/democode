package modell;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.tree.DefaultMutableTreeNode;

public class MyModel {
    public DefaultMutableTreeNode createTree(File file) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode(file.getName());
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                List<File> fileList = new ArrayList<>(Arrays.asList(files));
                fileList.sort((f1, f2) -> {
                    if (f1.isDirectory() && !f2.isDirectory()) {
                        return -1;
                    } else if (!f1.isDirectory() && f2.isDirectory()) {
                        return 1;
                    } else {
                        return f1.getName().compareToIgnoreCase(f2.getName());
                    }
                });

                for (File childFile : fileList) {
                    DefaultMutableTreeNode childNode = createTree(childFile);
                    node.add(childNode);
                }
            }
        }
        return node;
    }

    public void save(File file, DefaultMutableTreeNode rootNode) throws IOException {
        if (rootNode == null || rootNode.getParent() != null) {
            return;
        }

        if (rootNode.getAllowsChildren()) {
            file.mkdirs();
            for (int i = 0; i < rootNode.getChildCount(); i++) {
                DefaultMutableTreeNode childNode = (DefaultMutableTreeNode) rootNode.getChildAt(i);
                String childName = childNode.getUserObject().toString();
                File childFile = new File(file, childName);
                save(childFile, childNode);
            }
        } else {
            
        }
    }

    public DefaultMutableTreeNode load(File file) {
        return createTree(file);
    }
}