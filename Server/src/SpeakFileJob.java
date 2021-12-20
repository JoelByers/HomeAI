package Server.src;

import Utils.src.Job;

public class SpeakFileJob extends Job
{
    String filePath;

    public SpeakFileJob(String file)
    {
        filePath = file;
    }

    @Override
    public void initialize()
    {
        
    }

    @Override
    public boolean process()
    {
        Globals.systemAudio.speakFromFile(filePath);
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
