package Server.src;

import Utils.src.SerialComm;

public class RelayMod<Controller extends SerialComm>
{
    private Controller controller;
    private int size;

    public RelayMod(int size, Controller c)
    {
        this.size = size;
        controller = c;
    }

    public void write(byte relay, byte data) throws IndexOutOfBoundsException
    {
        if(relay > size)
        {
            throw new IndexOutOfBoundsException();
        }

        byte[] newData = new byte[2];
        newData[0] = relay;
        newData[1] = data;
        

        controller.write(newData);
    }
}