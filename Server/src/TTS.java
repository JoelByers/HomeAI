package Server.src;

import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.signalproc.effects.AudioEffect;
import marytts.signalproc.effects.EffectsApplier;
import marytts.util.data.audio.AudioPlayer;
import java.io.BufferedReader;
import java.io.FileReader;
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

    public AudioInputStream readFromFile(String file)
    {
        String nextLine = "";
        String output = "";

        try
        {
            BufferedReader fileIn = new BufferedReader(new FileReader(file));

            while((nextLine = fileIn.readLine()) != null)
            {
                output += nextLine;
            }
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }

        return convertText(output);
    }
}
