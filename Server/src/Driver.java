package Server.src;

import Server.src.GreetModule;

public class Driver
{
    public static void main(String[] args)
    {   
        IntroductionJob ij = new IntroductionJob();
        TimeModule timeMod = new TimeModule("time");
        GreetModule greetMod = new GreetModule("hello");
        ServerProcessor server = new ServerProcessor();

        while(!Globals.shutdown)
        {
        }      
    }
}
