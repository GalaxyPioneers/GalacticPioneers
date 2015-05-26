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
	int x, y;
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
    Player curPlayer = new Player();
	GalacticMenu thisMenu = new GalacticMenu(this);

    public void init()
    {
		back = new ImageIcon(this.getClass().getResource("Pics\\Background.JPG")).getImage();
		syst = new ImageIcon(this.getClass().getResource("Pics\\UnclaimedSyst.PNG")).getImage();
		setSize((int)width,(int)height);
		addMouseListener(this);
		frame = new JFrame();
		frame.setVisible(true);
		frame.pack();
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		frame.setSize((int)width,(int)height);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.add(this);
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		//frame.setIconImage(face);
		frame.setVisible(true);
        gameBoard = new Board(this);
		x = this.getWidth()/2;
		y = this.getHeight()/2;
		thisMenu.init();
		th = new Thread(this);
		th.start();
	}

	public void paint(Graphics g)
	{
        if(!InSyst)
        {
            g.drawImage(back, 0, 0, this.getWidth(), this.getHeight(), this);
			try{
            gameBoard.drawGrid(g);}catch(Exception e){}
			setSize((int) width, (int) height);
        }
        else if(InSyst)
        {
            currentSystem.render(g,this);
        }
		thisMenu.render(g,this);
	}
	public void update(Graphics g) {
        Image im = null;
        Graphics dubG = null;

        if (im == null) {
            im = createImage(this.getSize().width, this.getSize().height);
            dubG = im.getGraphics();
        }

        dubG.setColor(Color.black);
        dubG.fillRect(0, 0, this.getSize().width, this.getSize().height);
        dubG.setColor(getForeground());
        paint(dubG);
        g.drawImage(im, 0, 0, this);
    }

    public void run()
	{
		while(true)
		{
			repaint();
			try{
				Thread.sleep(17);
			}catch(InterruptedException e){}
		}
	}

	public void mouseClicked(MouseEvent e) {}
	public void mousePressed(MouseEvent e)
	{
		currentSystem = gameBoard.checkClick(e.getX(),e.getY(),gg,this);
		if(!(currentSystem==null))
			InSyst = true;
		System.out.println(e.getPoint()+"\n"+currentSystem.getPlanNum()+" "+currentSystem.getStarVal()+"\n");
	}
	public void mouseReleased(MouseEvent e){}
	public void mouseEntered(MouseEvent e){}
	public void mouseExited(MouseEvent e){}

	public static void main(String[] args)
	{
		GalacticDriver dr = new GalacticDriver();
		dr.init();
	}

	public void addMenu(GalacticMenu gm)
	{
		thisMenu = gm;
	}

	public Color getColor()
	{
		return curPlayer.getCol();
	}
}