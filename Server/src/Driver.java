package Server.src;

public class Driver
{
    public static void main(String[] args)
    {   
        IntroductionJob ij = new IntroductionJob();
        TimeModule timeMod = new TimeModule("time");
        ServerProcessor server = new ServerProcessor();

        while(!Globals.shutdown)
        {
        }      
    }
}
