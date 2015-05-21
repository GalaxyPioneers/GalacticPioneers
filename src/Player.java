import java.util.*;

public class Player
{
	int fleetSize;
	String color;

	public Player(int phleetSize, String pColor)
	{
		fleetSize = phleetSize;
		color = pColor;
	}
	public String getColor()
	{
		return this.color;
	}
}