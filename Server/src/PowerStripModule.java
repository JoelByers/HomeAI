package Server.src;

public class PowerStripModule extends Module
{
    public PowerStripModule(String key)
    {
        super(key);
    }   
    
    @Override
    public void run(String input)
    {
        System.out.println(input);
        Globals.jobProcessor.pushJob(new PowerStripJob(input));
    }
}
