package main;

import Entities.Character_Base;
import Entities.UNTA_character;

import java.awt.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    // > Screen settings:
    final int origTileSize = 64; // default size of the characters & tiles
    // final int scale = 3;
    public int tileSize = origTileSize;

    final int maxWTiles = 18;
    final int maxHTiles = 10;

    final int ScreenWidth = tileSize * maxWTiles; // 1152
    final int ScreenHeight = tileSize * maxHTiles; // 640

    // [FPS] - Frames per second
    int fps = 30;

    Thread gameThread; // FPS
    ControlKeys keyC = new ControlKeys();

    public GamePanel() {
        this.setPreferredSize(new Dimension(ScreenWidth, ScreenHeight));
        this.setBackground(Color.pink);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyC);
        this.setFocusable(true); // waits to receive key trigger
    }

    UNTA_character UNTA = new UNTA_character((int)(Math.random() * 100),
            (int)(Math.random() * 100), 5, 10, 2);

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        final int SkipTicks = 1000 / fps;
        final int MaxFrameSkip = 5;
        long NextGameTick = System.currentTimeMillis(); // 1000 -> 1 sec

        int loops;
        float interpt;

        // > CORE of the game:
        while (gameThread != null)
        {
            loops = 0;
            while (System.currentTimeMillis() > NextGameTick && loops < MaxFrameSkip)
            {
                update();

                NextGameTick += SkipTicks;
                loops++;
            }

            interpt = (float)(System.currentTimeMillis() + SkipTicks - NextGameTick / SkipTicks);
            repaint((long)interpt);
        }
    }

    public void update() {
        if (UNTA.CheckOutBorders(ScreenWidth, ScreenHeight))
        {
            if (keyC.UpArrow) { UNTA.PY -= UNTA.Speed; }
            if (keyC.DownArrow) { UNTA.PY += UNTA.Speed; }
            if (keyC.RightArrow) { UNTA.PX += UNTA.Speed; }
            if (keyC.LeftArrow) { UNTA.PX -= UNTA.Speed; }
        }
        else { UNTA.PY -= UNTA.Speed; UNTA.PX -= UNTA.Speed; }

        // UNTA.DrawImg();


    }

    public void paintComponent(Graphics G) {
        super.paintComponent(G);
        Graphics2D G2 = (Graphics2D)G; // more functions available
        G2.setColor(Color.orange);
        G2.fillRect(UNTA.PX, UNTA.PY, tileSize, tileSize);
        G2.dispose();
    }
}