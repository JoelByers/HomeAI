package Server.src;

import Utils.src.Job;

public class PowerStripJob extends Job
{
    String command;
    String[] responses = new String[] {"So Festive",
                                        "Salute The Sun",
                                        "So be it",
                                        "Well, That's brighter than your future",
                                        "I don't get paid enough for this",
                                        "Lazy Human, Gal Dang"
                                        };

    public PowerStripJob(String input)
    {
        command = input;
    }

    @Override
    public void initialize()
    {
    }

    @Override
    public boolean process()
    {
        if(command.indexOf("lights on") != -1)
        {
            HardwareInterface.powerStrip.write((byte) 0, (byte)1);
        }
        else if(command.indexOf("lights off") != -1)
        {
            HardwareInterface.powerStrip.write((byte) 0, (byte)0);
        }

        Globals.systemAudio.speak(TTS.getRandomResponse(responses));

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
