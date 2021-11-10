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
        System.out.println("Job " + job.getId() + " added to queue");
    } 

    private synchronized void processJob()
    {
        Job job = jobQueue.remove();

        if(job.parseCommand())
        {
            job.initialize();
            while(job.process())
            {
            }

            if(job.runBackground)
            {
                job.start();  // Starts new thread with background process
            }

            job.complete();
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
                }
    
                Thread.sleep(3000);  // Actual Possible Implementation
            }
            catch(InterruptedException exc)
            {
                exc.printStackTrace();
            }
        }
    }
}