package Server.src;

import Server.src.GreetModule;

public class Driver
{
    public static void main(String[] args)
    {   
        TimeModule timeMod = new TimeModule("time");
        GreetModule greetMod = new GreetModule("hello");
        StoryModule storyMod = new StoryModule("story");
        PowerStripModule powerMod = new PowerStripModule("lights");
        Globals.jobProcessor.pushJob(new SpeakFileJob("speechText/startup.txt"));
        ServerProcessor server = new ServerProcessor();

        while(!Globals.shutdown)
        {
        }      
    }
}
