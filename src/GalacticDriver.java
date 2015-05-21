import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;
import javax.swing.border.*;


public class GalacticDriver extends Applet
implements Runnable, MouseListener
{
	JFrame frame;
	Image back, syst;
	int x, y, sx = 200, sy = 100;
	int dx = 3,dy = 3;
	Thread th;
	Board gameBoard;
	Graphics gg;
	boolean graphy = true;
	Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	double width = screenSize.getWidth();
	double height = screenSize.getHeight();
    private boolean InSyst = false;
    Systim currentSystem = null;

    public void init()
	{
		gameBoard = new Board();
		back = new ImageIcon(this.getClass().getResource("Pics\\Background.JPG")).getImage();
		syst = new ImageIcon(this.getClass().getResource("Pics\\SystemImg.PNG")).getImage();
		setSize((int)width,(int)height);
		addMouseListener(this);
		frame = new JFrame();
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize(1440, 900);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setIconImage(face);
		frame.setVisible(true);
        sx = this.getWidth()/2-506;
		x = this.getWidth()/2;
		y = this.getHeight()/2;
		th = new Thread(this);
		th.start();
	}

	public void paint(Graphics g)
	{
        if(!InSyst)
        {
            g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), this);
            sx = this.getWidth() / 2 - 555;
            drawGrid(g);
            g.drawImage(syst, this.getWidth() / 2 - 90, 378, 180, 130, this);
            setSize((int) width, (int) height);
        }
        else if(InSyst)
        {
            currentSystem.render(g,this);
        }
	}
	public void update(Graphics g)
	{
		Image im = null;
		Graphics dubG = null;

		if(im == null)
		{
			im = createImage(this.getSize().width, this.getSize().height);
			dubG = im.getGraphics();
		}

		dubG.setColor(Color.black);
		dubG.fillRect(0, 0, this.getSize().width, this.getSize().height);
		dubG.setColor(getForeground());
		paint(dubG);
		g.drawImage(im, 0, 0, this);
	}

	public void drawGrid(Graphics g)
	{
		for(int i = 0;i<4;i++)
		{
			sy = 100;
			for(int j = 0;j<4;j++)
			{
 				g.drawImage(syst, sx, sy,180,130,this);
				gameBoard.setSystem(i,j,sx,sy);
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

	public void run()
	{
		while(true)
		{
			System.out.println(graphy);
			repaint();
			System.out.println("GIVE ME DA PUSI b0ss");
			try{
				Thread.sleep(17);
			}catch(InterruptedException e){}
		}
	}

	public void mouseClicked(MouseEvent e)
	{
		currentSystem = gameBoard.checkClick(e.getX(),e.getY(),gg,this);
        if(!(currentSystem==null))
            InSyst = true;
		System.out.println(e.getPoint());
	}
	public void mousePressed(MouseEvent e){}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public static void main(String[] args)
	{
		GalacticDriver dr = new GalacticDriver();
		dr.init();
	}
}