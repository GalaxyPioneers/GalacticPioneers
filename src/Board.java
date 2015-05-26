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
	private Systim centerSystim;
	int boardHeight, boardWidth;
    BufferedReader read;
    FileReader fil;

	public Board(Applet ap)
	{
		//oardHeight = (systems[3][3].getY())-(systems[0][0].getY());
		//boardWidth = (systems[3][3].getX())-(systems[0][0].getX());
        int pPlan = 0;
        int stVal = 0;
        centerSystim = new Systim(ap.getWidth() / 2 - 90, ap.getHeight() / 2 - 65,3,50);
		Image img = null;
        ArrayList<int[]> dats = new ArrayList<int[]>();
        try{
            fil = new FileReader("src\\Systims.txt");
            read = new BufferedReader(fil);
            String line;
            String[] data;
            while((line = read.readLine())!=null)
            {
                data = line.split("[,]");
                pPlan = Integer.parseInt(data[0]);
                stVal = Integer.parseInt(data[1]);
				if(data.length>=3)
				{
					img = new ImageIcon(ap.getClass().getResource("Pics\\"+data[2])).getImage();
				}
                dats.add(new int[]{pPlan, stVal});
            }
        }catch(IOException e){e.printStackTrace();}
		int sx = (int)(ap.getWidth()*.235);
		int sy;

		Iterator iter = dats.iterator();
		for(int i = 0;i<4;i++)
		{
			sy = (int)(ap.getHeight()*.18);
			for(int j = 0;j<4;j++)
			{
				int[] temp = (int[])(iter.next());
				if(img!=null)
					systems[i][j] = new Systim(sx,sy,temp[0],temp[1],img);
				else
					systems[i][j] = new Systim(sx,sy,temp[0],temp[1]);
				if(j == 1)
				{
					sy+=280;
				}
				else
				{sy+=140;}
			}
			if(i==1)
			{sx+=420;}
			else {sx+=210;}
		}
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
				else if(mx>centerSystim.getX()&&mx<centerSystim.getX()+180&&my>centerSystim.getY()&&my<centerSystim.getY()+130)
				{
					return centerSystim;
				}
			}
		}
		return null;
	}

	public void drawGrid(Graphics g)
	{
		for(int i = 0;i<4;i++)
		{
			for(int j = 0;j<4;j++)
			{
				g.drawImage(systems[i][j].getColor(),systems[i][j].getX(), systems[i][j].getY(),180,130,null);
			}
		}
		g.drawImage(centerSystim.getColor(),centerSystim.getX(),centerSystim.getY(),180,130,null);
	}
	public void setSystem(int i, int j, int sx, int sy)
	{
        try {
            systems[i][j].setCoords(sx, sy);
        }catch(NullPointerException e){}
	}

	public Systim[][] getBoard()
	{
		return systems;
	}

}