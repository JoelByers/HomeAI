package Server.src;

import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.signalproc.effects.AudioEffect;
import marytts.signalproc.effects.EffectsApplier;
import marytts.util.data.audio.AudioPlayer;
import java.io.IOException;
import javax.sound.sampled.AudioInputStream;

import marytts.LocalMaryInterface;

public class TTS
{
    private MaryInterface mary;
    private EffectsApplier effects = new EffectsApplier();
    private final String robotEffect = "Robot(amount=100)";
    private final String pilotEffect = "JetPilot(amount=75)";

    public TTS()
    {
        try
        {
            mary = new LocalMaryInterface();
        }
        catch(MaryConfigurationException exc)
        {
            exc.printStackTrace();
        }
        
        mary.setVoice("cmu-bdl-hsmm");
    }

    public AudioInputStream convertText(String text)
    {
        AudioInputStream outputStream = null;

        try
        {
            outputStream = mary.generateAudio(text);
            //outputStream = effects.apply(outputStream, robotEffect);

        }
        catch(SynthesisException exc)
        {
            exc.printStackTrace();
        }

        return outputStream;
    }
/*
    public void speak(String text)
    {
        try(AudioInputStream audioStream = mary.generateAudio(text))
        {
            //AudioInputStream effectSream = effects.apply(audioStream, robotEffect);
            AudioPlayer player = new AudioPlayer(audioStream);
            player.start();
            
        }
        catch(SynthesisException exc)
        {
            exc.printStackTrace();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }
    */
}
