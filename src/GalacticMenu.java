import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.border.*;

public class GalacticMenu {
    Color theme;
    GalacticDriver drivs;
    ArrayList<MenuItm> items = new ArrayList<MenuItm>();

    public GalacticMenu(GalacticDriver gd) {
        drivs = gd;
        theme = drivs.getColor();
    }

    public void init()
    {
        items.add(new MenuItm(30,1020,100,40));
    }
    public void render(Graphics g, Applet ap)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(theme);
        double thickness = 45.0;
        Stroke oldStroke = g2.getStroke();
        g2.setStroke(new BasicStroke((float)thickness));
        g2.drawRect(0, 0, ap.getWidth(), ap.getHeight()-20);
        g2.setStroke(oldStroke);
        g2.setColor(Color.gray);
        for(MenuItm temp : items)
        {
            temp.render(g);
        }
    }

    class MenuItm
    {
        int x, y, lenX, lenY;
        boolean selected = false;

        public MenuItm(int px, int py, int pLenX, int pLenY)
        {
            x = px;
            y = py;
            lenX = pLenX;
            lenY = pLenY;
        }
        public boolean checkHover(int mx, int my)
        {
            if(mx>x&&mx<x+lenX&&my>y&&my<y+lenY)
            {
                selected = true;
                return true;
            }
            else {
                selected = false;
                return false;
            }
        }
        public void render(Graphics g)
        {
            g.setColor(Color.black);
            g.drawRect(x,y,lenX,lenY);
        }
    }
}
