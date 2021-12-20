package Server.src;

import Utils.src.Job;

public class SpeakJob extends Job
{
    String spokenText;

    public SpeakJob(String text)
    {
        spokenText = text;
    }

    @Override
    public void initialize()
    {
        
    }

    @Override
    public boolean process()
    {
        Globals.systemAudio.speak(spokenText);
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
