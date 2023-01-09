package Utils.src;

import java.util.Queue;
import java.util.LinkedList;

public class JobProcessor extends Thread
{
    private Queue<Job> jobQueue = new LinkedList<Job>();

    public JobProcessor()
    {
        this.start();
    }

    public void pushJob(Job job)
    {
        jobQueue.add(job);
        System.out.println("Job added to queue");
    } 

    private synchronized void processJob()
    {
        Job job = jobQueue.remove();

        while(job.run())
        {
        }   
    }

    @Override
    public void run()
    {   
        while(true)
        {
            try
            {
                if(jobQueue.size() > 0)
                {
                    System.out.println("Processing Job");
                    processJob();
                    System.out.println("Job Done");
                }
    
                Thread.sleep(3000);  // Must Pause
            }
            catch(InterruptedException exc)
            {
                exc.printStackTrace();
            }
        }
    }
}