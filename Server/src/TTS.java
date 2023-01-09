package Server.src;

import marytts.MaryInterface;
import marytts.exceptions.MaryConfigurationException;
import marytts.exceptions.SynthesisException;
import marytts.signalproc.effects.AudioEffect;
import marytts.signalproc.effects.EffectsApplier;
import marytts.signalproc.effects.JetPilotEffect;
import marytts.signalproc.effects.VocalTractLinearScalerEffect;
import marytts.util.data.audio.AudioPlayer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import marytts.LocalMaryInterface;

// full effects
// https://www.home-assistant.io/integrations/marytts/

public class TTS
{
    private MaryInterface mary;
    private EffectsApplier effects = new EffectsApplier();
    private final String robotEffect = "Robot(amount=100)";
    private final String pilotEffect = "JetPilot(amount=25)";
    private final String scalarEffect = "TractScalar(amount=0.5)";
    private final String rateEffect = "Rate(amount=0.1)";
    private final String f0Scale = "f0Scale(f0Scale=0.1)";

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
            outputStream = effects.apply(outputStream, f0Scale);

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

    public static String getRandomResponse(String[] options)
    {
        Random rand = new Random();

        return options[rand.nextInt(options.length)];
    }
}
