package main;
import jdk.javadoc.doclet.Taglet;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        JFrame Window = new JFrame();

        Window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Window.setResizable(false);

        Window.setTitle("< Unta's adventure >");

        GamePanel GP = new GamePanel();
        Window.add(GP);
        Window.pack();

        Window.setLocationRelativeTo(null);
        Window.setVisible(true);

        GP.startGameThread();
    }
}