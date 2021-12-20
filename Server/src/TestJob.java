package Server.src;

import Utils.src.Job;

public class TestJob extends Job
{
    public TestJob()
    {
        super();
    }

    @Override
    public void initialize()
    {
        System.out.println(jobID + " Initialized");
    }

    @Override
    public boolean process()
    {
        try
        {
            Globals.systemAudio.speak("test job " + jobID + " is being processed");
            Thread.sleep(3000);
        }
        catch(InterruptedException exc)
        {
            exc.printStackTrace();
        }

        System.out.println(jobID + " Running Now!");
        return false;
    }

    @Override
    protected boolean background() 
    {
        try
        {
            for(int i = 0; i < 10; i++)
            {
                System.out.println("Job " + jobID + " Background Counter: " + i);
                Thread.sleep(3000);
            }
        }
        catch(InterruptedException exc)
        {
            exc.printStackTrace();
        }


        return false;
    }

    @Override
    public void complete() 
    {
        System.out.println(jobID + " Complete");
    }
}
