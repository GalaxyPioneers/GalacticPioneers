import javax.swing.*;
import java.util.*;
import java.awt.*;

public class Player
{
	private int fleetSize;
	String color;
    private Image sys;

    private ArrayList<Ship>fleet = new ArrayList<Ship>();

	public Player(int phleetSize, String pColor)
	{
		fleetSize = phleetSize;
		color = pColor;
        sys = new ImageIcon(getClass().getResource("Pics\\"+color+"Syst.PNG")).getImage();
	}
	public Image getColor()
	{
		return this.sys;
	}
    public Player(int pfleetSize)
    {
        fleetSize = pfleetSize;
    }
    public int getFleetSize()
    {
        return fleetSize;
    }
    public void addShipToFleet(Ship shipthing)
    {
        fleet.add(shipthing);
    }
}