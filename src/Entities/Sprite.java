package Entities;
// import org.joml.Vector2f;

import main.GamePanel;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Sprite {

    // Width = Height => 64 [!]
    // private int[] Coordinates;
    GamePanel GP;

    private BufferedImage WholeImg, FrameImg;

    public BufferedImage loadImg(String path) throws IOException
    {
        WholeImg = ImageIO.read(getClass().getResource(path));
        return WholeImg;
    }

    public BufferedImage Sprite(int num_of_SprColumns, int Rows, int spacing)
    {
        FrameImg = WholeImg.getSubimage(
                (num_of_SprColumns * GP.tileSize) - GP.tileSize,
                (Rows * GP.tileSize) - GP.tileSize,
                GP.tileSize, GP.tileSize);

        return FrameImg;
    }
}
