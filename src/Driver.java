public class Driver
{
    public static void main(String[] args)
    {        
        IntroductionJob ij = new IntroductionJob();
        TestJob tj = new TestJob();
        TimeModule timeMod = new TimeModule("time");
            
        //Globals.jobProcessor.pushJob(ij);
        //Globals.jobProcessor.pushJob(tj);

        while(!Globals.shutdown)
        {
        }      
    }
}
