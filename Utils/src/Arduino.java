package Utils.src;

import com.fazecast.jSerialComm.SerialPort;

public class Arduino
{
    private SerialPort port;

    public Arduino()
    {
        port = SerialPort.getCommPorts()[0];
        port.openPort();
    }

    public void write(byte[] data)
    {
        byte inputBuff[] = new byte[]{0};

        do
        {
            port.readBytes(inputBuff, 1);
        }
        while(inputBuff[0] != 1);

        for(int i = 0; i < 10; i++)
        {
            port.writeBytes(new byte[]{1}, 1);
        }
    }
}
