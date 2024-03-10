package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ControlKeys implements KeyListener {

    public boolean UpArrow, DownArrow, LeftArrow, RightArrow;

    @Override
    public void keyTyped(KeyEvent e) {
        // NOT used
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) // 224
        {
            UpArrow = true;
        }

        if (keyCode == KeyEvent.VK_DOWN) // 225
        {
            DownArrow = true;
        }

        if (keyCode == KeyEvent.VK_LEFT) // 226
        {
            LeftArrow = true;
        }

        if (keyCode == KeyEvent.VK_RIGHT) // 227
        {
            RightArrow = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_UP) // 224
        {
            UpArrow = false;
        }

        if (keyCode == KeyEvent.VK_DOWN) // 225
        {
            DownArrow = false;
        }

        if (keyCode == KeyEvent.VK_LEFT) // 226
        {
            LeftArrow = false;
        }

        if (keyCode == KeyEvent.VK_RIGHT) // 227
        {
            RightArrow = false;
        }
    }
}
