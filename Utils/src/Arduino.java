package Utils.src;

import com.fazecast.jSerialComm.SerialPort;

public class Arduino
{
    private SerialPort port;

    public Arduino()
    {
        port = SerialPort.getCommPorts()[0];
        port.openPort();

        byte inputBuff[] = new byte[]{0};

        do
        {
            port.readBytes(inputBuff, 1);
        }
        while(inputBuff[0] != 1);
    }

    public void write(byte[] data)
    {
        for(int i = 0; i < 10; i++)
        {
            port.writeBytes(data, data.length);
        }
    }
}
