package Server.src;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.SourceDataLine;

public class AudioController extends Thread
{
    TTS tts = new TTS();
    private Queue<AudioInputStream> streamQueue = new LinkedList<AudioInputStream>();  

    public AudioController()
    {
        this.setPriority(4);
        this.start();
    }

    @Override
    public void run()
    {
        try
        {
            while(!Globals.shutdown)
            {
                if(streamQueue.size() > 0)
                {
                    playStream(streamQueue.remove());
                }
    
                Thread.sleep(30);
            }
        }
        catch(InterruptedException exc)
        {
            exc.printStackTrace();
        }
    }

    public void queueStream(AudioInputStream audioStream)
    {
        streamQueue.add(audioStream);
    }

    private void playStream(AudioInputStream audioStream)
    {
        try
        {
            int BUFFER_SIZE = 4096;
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
            AudioFormat format = audioStream.getFormat();
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(info);

            audioLine.open(format);
            audioLine.start();

            while ((bytesRead = audioStream.read(bytesBuffer)) != -1)
            {
                audioLine.write(bytesBuffer, 0, bytesRead);
            }

            audioLine.drain();
            audioLine.close();
            audioStream.close();
        }
        catch(LineUnavailableException exc)
        {
            exc.printStackTrace();
        }
        catch(IOException exc)
        {
            exc.printStackTrace();
        }
    }

    public void speak(String text)
    {
        queueStream(tts.convertText(text));
    }

    public void speakFromFile(String file)
    {
        queueStream(tts.readFromFile(file));
    }
}
