package Server.src;

import Server.src.IntroductionJob;

public class GreetModule extends Module
{
    public GreetModule(String key)
    {
        super(key);
    }

    @Override
    public void run(String input)
    {
        Globals.jobProcessor.pushJob(new IntroductionJob());
    }
    
}
