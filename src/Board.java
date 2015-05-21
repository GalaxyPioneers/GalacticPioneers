import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.border.*;

public class Board
{
	private Systim[][] systems = new Systim[4][4];

	public Board()
	{
        systems[0][0] = new TestSystem(0,0);
	}

	public Systim checkClick(int mx, int my, Graphics g,Applet ap)
	{
		for(int i = 0;i<systems.length;i++)
		{
			for(int j = 0;j<systems[0].length;j++)
			{
				Systim cur = systems[i][j];
				//System.out.println(cur.getX()+" "+cur.getY()+": "+mx);
				if(mx>cur.getX()&&mx<cur.getX()+180&&my>cur.getY()&&my<cur.getY()+130)
				{
					return cur;
				}
			}
		}
		return null;
	}

	public void setSystem(int i, int j, int sx, int sy)
	{
        try {
            systems[i][j].setCoords(sx, sy);
        }catch(NullPointerException e){}
	}

}