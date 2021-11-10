package Server.src;

public class StoryModule extends Module
{
    public StoryModule(String key)
    {
        super(key);
    }

    @Override
    public void run()
    {
        Globals.systemAudio.speakFromFile("./speechText/darthPlagus.txt");
    }
}
