package Server.src;

import Utils.src.Job;

public class SpeakJob implements Job
{
    String spokenText;

    public SpeakJob(String text)
    {
        spokenText = text;
    }

    @Override
    public boolean run()
    {
        Globals.systemAudio.speak(spokenText);
        return false;
    }
}
