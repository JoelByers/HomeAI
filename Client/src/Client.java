import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import Utils.src.Job;

public class Client
{
    private Socket clientSocket;
    private ObjectOutputStream out;
    private ObjectInputStream in;

    public Client()
    {
        try
        {
            clientSocket = new Socket("192.168.1.126", 5000);
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            in = new ObjectInputStream(clientSocket.getInputStream());
        }
        catch(UnknownHostException exc)
        {
            exc.printStackTrace();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public Job sendJob(Job job)
    {
        Job newJob = null;

        try
        {
            out.writeObject(job);
            newJob = (Job)in.readObject();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
        catch(ClassNotFoundException exc)
        {
            exc.printStackTrace();
        }

        return newJob;
    }
}
