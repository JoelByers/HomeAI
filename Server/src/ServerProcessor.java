package Server.src;

import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ServerProcessor extends Thread
{
    private ServerSocket serverSocket;
    private Socket clientSocket;
    private DataInputStream dataIn;

    public ServerProcessor()
    {
        try
        {
            serverSocket = new ServerSocket(25);
        }
        catch(UnknownHostException exc)
        {
            exc.printStackTrace();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }

        this.start();
    }

    @Override
    public void run()
    {
        try
        {
            while(!Globals.shutdown)
            {
                clientSocket = serverSocket.accept();
                ObjectOutputStream out = new ObjectOutputStream(clientSocket.getOutputStream());
                ObjectInputStream in = new ObjectInputStream(clientSocket.getInputStream());
            }
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }
}
