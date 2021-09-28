import java.util.LinkedList;

public abstract class Job extends Thread
{
    private static long nextJobID = 0;
    protected long jobID;
    public boolean runBackground;

    private String command;
    private LinkedList<String> parsedCommand = new LinkedList<String>();

    public Job()
    {
        runBackground = false;

        jobID = nextJobID;
        nextJobID++;
    }

    public Job(String inputCommand)
    {
        this();
        command = inputCommand;
    }

    public long getJobID()
    {
        return jobID;
    }

    @Override
    public void run()
    {
        while(background())
        {
        }
    }

    public abstract boolean parseCommand();
    public abstract void initialize();
    public abstract boolean process();
    protected abstract boolean background();
    public abstract void complete();
}
