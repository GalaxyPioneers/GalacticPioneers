import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.*;
import java.awt.*;

public class Player {
    private int fleetSize;
    Color color;
    String col;
    private Image sys;
    private DataInputStream in;
    private DataOutputStream out;
    Socket sock;
    private int id;
    Color[] colors = {Color.red,Color.blue,Color.green,Color.yellow};


    private ArrayList<Ship> fleet = new ArrayList<Ship>();

    public Player() {
        try {
            System.out.println("Connecting...");
            sock = new Socket("localhost", 4444);
            in = new DataInputStream(sock.getInputStream());
            out = new DataOutputStream(sock.getOutputStream());
            System.out.println("Connected!");
            id = in.readInt();
            col = in.readUTF();
            System.out.println(id+" "+ col);
            color = colors[id];
        }catch(IOException e){System.out.println("Could not establish connection to server");}
    }

    public Player(int phleetSize, Color pColor, String cp) {
        fleetSize = phleetSize;
        color = pColor;
        col = cp;
        System.out.println(color.toString());
        sys = new ImageIcon(getClass().getResource("Pics\\" + cp + "Syst.PNG")).getImage();
    }

	public Image getColor()
	{
		return this.sys;
	}
    public Color getCol(){return this.color;}
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