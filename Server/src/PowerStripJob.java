package Server.src;

import Utils.src.Job;

public class PowerStripJob implements Job
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
    public boolean run()
    {
        if(command.indexOf("lights") != -1 && command.indexOf("on") != -1)
        {
            HardwareInterface.powerStrip.write((byte) 0, (byte)1);
        }
        else if(command.indexOf("lights") != -1 && command.indexOf("off") != -1)
        {
            HardwareInterface.powerStrip.write((byte) 0, (byte)0);
        }

        Globals.systemAudio.speak(TTS.getRandomResponse(responses));

        return false;
    }
}
