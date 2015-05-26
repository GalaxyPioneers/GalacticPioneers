import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;

public class Systim {
    private int x, y, planNum, StarVal;
    public int plan1, plan2, plan3;
    String color = "gray";
    Player owner = null;
    Image systImg, backs;

    public Systim(int pX, int pY) {
        x = pX;
        y = pY;
        systImg = new ImageIcon(getClass().getResource("Pics\\UnclaimedSyst.PNG")).getImage();
    }

    public Systim(int pX, int pY, int pplanNum, int pStarVal) {
        x = pX;
        y = pY;
        planNum = pplanNum;
        StarVal = pStarVal;
        systImg = new ImageIcon(getClass().getResource("Pics\\UnclaimedSyst.PNG")).getImage();
    }
    public Systim(int pX, int pY, int pplanNum, int pStarVal, Image im) {
        x = pX;
        y = pY;
        planNum = pplanNum;
        StarVal = pStarVal;
        backs = im;
        systImg = new ImageIcon(getClass().getResource("Pics\\UnclaimedSyst.PNG")).getImage();
    }

    public void setCoords(int px, int py) {
        x = px;
        y = py;
    }

    public void setOwner(Player p)
    {
        owner = p;
        systImg = owner.getColor();
    }

    public Image getColor() {
        return systImg;
    }

    public void render(Graphics g, Applet ap)
    {
        g.drawImage(backs,0,0,ap.getWidth(),ap.getHeight(),null);
    }

	public int getX(){return x;}
	public int getY(){return y;}


    public int getPlanNum()
    {
        return planNum;
    }
    public int getStarVal()
    {
        return StarVal;
    }
    public void setPlanetReasource(int matter, int plan)
    {
        if(plan ==1)
        {
            plan1 = matter;
        }
        if(plan ==2)
        {
            plan2 = matter;
        }
        if(plan ==3)
        {
            plan3 = matter;
        }
    }
}