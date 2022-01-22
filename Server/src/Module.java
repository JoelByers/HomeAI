package Server.src;

import java.util.LinkedList;
import java.util.List;

public abstract class Module
{
    private static List<Module> allInstances = new LinkedList<Module>();
    private String keyWord;
    private static final String entryPhrase = "ok boris ";
    
    public Module(String key)
    {
        keyWord = key;
        allInstances.add(this);
    }

    public final boolean hasKey(String input)
    {
        if(input.indexOf(entryPhrase + keyWord) != -1)
        {
            return true;
        }
        else
        {
            return false;
        }   
    }

    public abstract void run(String input);

    public static void searchAndRun(String input)
    {
        for(int i = 0; i < allInstances.size(); i++)
        {
            if(allInstances.get(i).hasKey(input))
            {
                allInstances.get(i).run(input);
            }
        }
    }
}
