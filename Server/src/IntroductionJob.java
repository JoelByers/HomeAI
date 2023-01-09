package Server.src;

import Utils.src.Job;

public class IntroductionJob implements Job
{
    @Override
    public boolean run() 
    {
        Globals.systemAudio.speak("Hello, my name is " + Globals.voiceName + ", the artificial intelligence created to serve the fort bushfire.");
        Globals.systemAudio.speak("My systems are online and standing by, ready to assist with operations");

        return false;
    }
}
