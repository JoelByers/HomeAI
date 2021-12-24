package Server.src;

import Utils.src.Job;

public class SpeakFileJob implements Job
{
    String filePath;

    public SpeakFileJob(String file)
    {
        filePath = file;
    }

    @Override
    public boolean run()
    {
        Globals.systemAudio.speakFromFile(filePath);
        return false;
    }
}
