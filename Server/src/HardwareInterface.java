package Server.src;

import Utils.src.Arduino;

public class HardwareInterface
{
    //public static Arduino powerStrip = new Arduino();

    public static RelayMod<Arduino> powerStrip = new RelayMod<Arduino>(2, new Arduino());
}
