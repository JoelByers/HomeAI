package Server.src;

import Utils.src.Job;

public class TestJob implements Job
{
    public TestJob()
    {
        super();
    }

    @Override
    public boolean run()
    {
        try
        {
            Globals.systemAudio.speak("test job is being processed");
            Thread.sleep(3000);
        }
        catch(InterruptedException exc)
        {
            exc.printStackTrace();
        }

        System.out.println("Job Running Now!");
        return false;
    }
}
