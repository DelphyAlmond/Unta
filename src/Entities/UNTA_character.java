package Entities;

import main.ControlKeys;
import java.awt.*;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.HashMap;
import java.util.Map;


public class UNTA_character extends Character_Base {

    ControlKeys keyC;
    private BufferedImage Sps = null;
    Map<String, String> map = new HashMap<>();

    public UNTA_character(int px, int py, int speed, int hp, int damage) {
        super(px, py, speed, hp, damage);
    }

    public void VectorImageConnection()
    {
        map.put("U", "^");
        map.put("D", "v");
        map.put("L", "<"); // DO NOT FORGET: mirror right position
        map.put("R", "../TextureImages/Sprite_RightRUNNING.png");
        map.put("N", "../TextureImages/Sprite_FrontSTANDING.png"); // no move
    }

    public void DrawImg()
    {
        String CurrSprite;
        if (keyC.RightArrow)
        {
            CurrSprite = map.get("R"); // <
        }
        if (keyC.LeftArrow)
        {
            CurrSprite = map.get("L");
        }
        if (keyC.UpArrow)
        {
            CurrSprite = map.get("U");
        }
        if (keyC.DownArrow)
        {
            CurrSprite = map.get("D");
        }
        else { CurrSprite = map.get("N"); } // <
    }
}
