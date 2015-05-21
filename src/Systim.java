import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.applet.*;
import java.util.*;
import java.io.*;
import java.awt.image.*;

public abstract class Systim
{
	int x, y;

	public Systim(int pX, int pY)
	{
		x = pX;
		y = pY;
	}

	public void setCoords(int px, int py)
	{
		x = px; y = py;
	}
	public abstract void render(Graphics g, Applet ap);

	public int getX(){return x;}
	public int getY(){return y;}
}