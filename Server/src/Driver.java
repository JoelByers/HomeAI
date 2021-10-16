public class Driver
{
    public static void main(String[] args)
    {        
        IntroductionJob ij = new IntroductionJob();
        TestJob tj = new TestJob();
        TimeModule timeMod = new TimeModule("time");
        ServerProcessor server = new ServerProcessor();
            
        Globals.jobProcessor.pushJob(ij);
        //Globals.jobProcessor.pushJob(tj);

        while(!Globals.shutdown)
        {
        }      
    }
}
