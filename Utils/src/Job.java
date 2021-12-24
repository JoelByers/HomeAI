package Utils.src;

import java.util.LinkedList;

public interface Job
{
    public boolean run();

    default boolean defRun()
    {
        return false;
    }
}
