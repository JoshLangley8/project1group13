import java.io.*;
import java.util.*;
import java.net.*;
 
public class Server
{
    Vector<ClientHandler> vec = new Vector<>();
    static int numClient = 0;
    public static void main(String[] args) throws IOException
    {
        ServerSocket servsock = new ServerSocket(/*Not sure which socket to use yet*/);
        Socket sock;
         
        while (true)
        {
            sock = servsock.accept();
            DataOutputStream outd = new DataOutputStream(sock.getOutputStream());
            DataInputStream inp = new DataInputStream(sock.getInputStream());  
            ClientHandler cHand = new ClientHandler(sock,"client num: " + numClient, inp, outd);

            System.out.println("Creating new client");
            Thread thr = new Thread(cHand);
             
            System.out.println("Adding client");
            vec.add(cHand);
          
            thr.start();
            numClient++;
 
        }
    }
}
