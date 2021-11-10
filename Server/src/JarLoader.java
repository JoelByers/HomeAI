import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.LinkedList;
import java.util.List;

public class JarLoader
{
    private List<File> jars = new LinkedList<File>();
    private URL[] jarUrls;
    private URLClassLoader classLoader;

    public void loadFromDir(String dir)
    {
        File directory = new File(dir);

        if(directory.exists())
        {
            for(File f : directory.listFiles())
            {
                jars.add(f);
            }
        }
        else
        {
            System.out.println("Unable to load Jars: Can't find \"" + dir + "\"");
        }

        jarUrls = new URL[jars.size()];

        for(int i = 0; i < jars.size(); i++)
        {
            try
            {
                jarUrls[i] = jars.get(i).toURI().toURL();
            } 
            catch(MalformedURLException exc) 
            {
                exc.printStackTrace();
            }
        }

        classLoader = new URLClassLoader(jarUrls, ClassLoader.getSystemClassLoader());
    }
}