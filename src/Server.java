import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.ArrayIndexOutOfBoundsException;import java.lang.String;import java.lang.System;import java.lang.Thread;import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by Basketlord on 5/25/2015.
 */
public class Server {
    static ServerSocket sock;
    static Socket socket;
    static DataOutputStream out;
    static DataInputStream in;
    static InetAddress ip;
    static int playerNum;
    static User[] users = new User[4];

    public static void main(String[] args)
    {
        try{
            System.out.println("Starting server...");
            ip = InetAddress.getLocalHost();
            sock = new ServerSocket(4444);
            System.out.println("Server Started...");}catch(IOException e){}
        while(true)
        {
            try{
                if(playerNum<4) {
                    socket = sock.accept();
                    System.out.println("Client Joined from: " + socket.getInetAddress());
                }
                for(int i = 0;i<=users.length;i++)
                {
                    out = new DataOutputStream(socket.getOutputStream());
                    in = new DataInputStream(socket.getInputStream());
                    try{
                        if(users[i] == null)
                        {
                            users[i] = new User(out, in, users,i);
                            Thread th = new Thread(users[i]);
                            th.start();
                            playerNum++;
                            break;
                        }}catch(ArrayIndexOutOfBoundsException a){System.out.println("SERVER IS FULL");}
                }
            }catch(IOException e){}
            //out = new ObjectOutputStream(socket.getOutputStream());
            //out.writeUTF("This is a test of Java sockets, Fuck you");
        }
    }
}
