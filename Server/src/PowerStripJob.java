package Server.src;

import Utils.src.Job;

public class PowerStripJob extends Job
{
    String command;

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
            Globals.powerStrip.write(new byte[]{1});
        }
        else if(command.indexOf("lights off") != -1)
        {
            Globals.powerStrip.write(new byte[]{0});
        }

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
