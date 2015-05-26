import java.io.*;
import java.io.BufferedReader;import java.io.DataInputStream;import java.io.DataOutputStream;import java.io.FileReader;import java.io.IOException;import java.lang.ArrayIndexOutOfBoundsException;import java.lang.Exception;import java.lang.Runnable;import java.lang.String;import java.net.*;
import java.util.*;

public class User extends Server
        implements Runnable
{
    DataOutputStream out;
    DataInputStream in;
    User[] user = new User[4];
    User testUser;
    String name;
    int playerID;
    FileReader red;
    BufferedReader br;
    String color;
    String[] colors = {"red","blue","green","yellow"};

    public User(DataOutputStream out, DataInputStream in, User[] pUser, int pID)
    {
        try{
        red = new FileReader("Systims.txt");
        br = new BufferedReader(red);}catch(Exception e){}
        this.out = out;
        this.in = in;
        this.user = pUser;
        this.playerID = pID;
        this.color = colors[pID];
    }

    public void run()
    {
        try{
        out.writeInt(this.playerID);
        out.writeUTF(colors[playerID]);}catch(IOException e){System.out.println("Failed to send PlayerID");}
        while(true)
        {
            try{

                for(int i = 0;i<4;i++)
                {
                    try{
                        if((testUser = user[i])!=null)
                        {
                            //System.out.println(yin+" "+playerIDin);
                        }}catch(ArrayIndexOutOfBoundsException a){}
                }
            }catch(Exception e)
            {
                try{
                    user[playerID] = null;
                    out.close();
                    in.close();}catch(IOException ex){}
            }


        }
    }
}