public class STT extends Thread
{
    public STT()
    {
        voce.SpeechInterface.init("voce-0.9.1/lib", 
        false, true, "grammar", "assistant"); 

        this.start();
    }

    public String getString()
    {
        if(voce.SpeechInterface.getRecognizerQueueSize() > 0)
        {
            return voce.SpeechInterface.popRecognizedString();
        }
        else
        {
            return "";
        }
    }

    @Override
    public void run()
    {
        String lastString;

        while(!Globals.shutdown)
        {
            try
            {
                if((lastString = getString()) != "")
                {
                    System.out.println(lastString);
                    Module.searchAndRun(lastString);
                }
    
                Thread.sleep(30);
            }
            catch(InterruptedException exc)
            {
                exc.printStackTrace();
            }
        }
    }
}
