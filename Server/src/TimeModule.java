package Server.src;

import java.time.LocalTime;

public class TimeModule extends Module
{
    public TimeModule(String in)
    {
        super(in);
    }

    @Override
    public void run()
    {
        LocalTime time = LocalTime.now();
        String out = "it is ";
        out += (time.getHour() < 12) ? time.getHour() : time.getHour() - 12;
        out += (" " + time.getMinute());
        out += (" " + ((time.getHour() < 12 || time.getHour() == 24) ? "a m." : "p m."));
        
        Globals.systemAudio.speak(out);
    }
}
