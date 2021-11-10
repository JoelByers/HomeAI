package Server.src;

import Server.src.IntroductionJob;

public class GreetModule extends Module
{
    public GreetModule(String key)
    {
        super(key);
    }

    @Override
    public void run()
    {
        Globals.jobProcessor.pushJob(new IntroductionJob());
    }
    
}
