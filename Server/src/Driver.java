package Server.src;

import Server.src.GreetModule;

public class Driver
{
    public static void main(String[] args)
    {   

        TimeModule timeMod = new TimeModule("time");
        GreetModule greetMod = new GreetModule("hello");
        StoryModule storyMod = new StoryModule("story");

        ServerProcessor server = new ServerProcessor();

        while(!Globals.shutdown)
        {
        }      
    }
}
