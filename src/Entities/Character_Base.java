package Entities;

import javax.swing.plaf.basic.BasicTreeUI;
import java.awt.*;

public class Character_Base {
    protected int SIZEQ = 64;
    public int PX;
    public int PY;

    public int Speed;
    public int HP;
    public int Damage;

    public boolean CheckOutBorders(int width, int height)
    {
        if (this.PX + this.SIZEQ > width || this.PY + this.SIZEQ > height)
        {
            return false;
        }
        return true;
    }

    public Character_Base(int px, int py, int speed, int hp, int damage)
    {
        this.PX = px;
        this.PY = py;
        this.Speed = speed;
        this.HP = hp;
        this.Damage = damage;
    }

    //public void DrawImg()
    //{
    //    if (keyC.RightArrow)
    //    {
    //
    //    }
    //}
}
