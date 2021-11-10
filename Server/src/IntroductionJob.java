package Server.src;

import Utils.src.Job;

public class IntroductionJob extends Job
{
    @Override
    public boolean parseCommand()
    {
        return true;
    }

    @Override
    public void initialize() 
    {        
    }

    @Override
    public boolean process() 
    {
        Globals.systemAudio.speak("Hello, my name is " + Globals.voiceName + ", the artificial intelligence created to serve the starship bushfire.");
        Globals.systemAudio.speak("My systems are online and standing by, ready to assist with operations");

        return false;
    }

    @Override
    protected boolean background() 
    {
        return false;
    }

    @Override
    public void complete() 
    {
        
    }
    
}
