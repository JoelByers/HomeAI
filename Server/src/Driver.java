package Server.src;

import Server.src.GreetModule;
import Server.src.IntroductionJob;
import Utils.src.Job;

public class Driver
{
    public static void main(String[] args)
    {   
        System.out.println("\nThe Borris Project");

        TimeModule timeMod = new TimeModule("time");
        GreetModule greetMod = new GreetModule("hello");
        StoryModule storyMod = new StoryModule("story");
        PowerStripModule powerMod = new PowerStripModule("lights");
        //Globals.jobProcessor.pushJob(new SpeakFileJob("speechText/startup.txt"));
        Globals.jobProcessor.pushJob(new Job()
        {
            @Override
            public boolean run()
            {
                System.out.println("Lambda");
                return false;
            }
        });

        Globals.jobProcessor.pushJob(new IntroductionJob());
        ServerProcessor server = new ServerProcessor();

        while(!Globals.shutdown)
        {
        }      
    }
}
