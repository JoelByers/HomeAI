package Server.src;

import Utils.src.Arduino;
import Utils.src.JobProcessor;

public class Globals 
{
    public static AudioController systemAudio = new AudioController();
    public static STT stt = new STT();
    public static JobProcessor jobProcessor = new JobProcessor();
    public static Arduino powerStrip = new Arduino();

    // System Variables
    public static boolean shutdown = false;

    // String Constants
    public final static String voiceName = "Boris";
}
