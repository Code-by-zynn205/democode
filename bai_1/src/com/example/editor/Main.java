package com.example.editor;

import java.awt.EventQueue;

import modell.MyModel;
import view.MyView;
import controller.MyController;

public class Main {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                MyView view = new MyView();
                MyModel model = new MyModel();
                MyController controller = new MyController(view, model);
                view.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }}
