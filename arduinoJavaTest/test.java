import com.fazecast.jSerialComm.*;

public class test
{
    public static void main(String[] args) throws InterruptedException
    {
        byte[] inputBuff = new byte[]{0};
        SerialPort comm = SerialPort.getCommPorts()[0];
        comm.openPort();
        System.out.println(comm.isOpen());

        do
        {
            comm.readBytes(inputBuff, 1);
        }
        while(inputBuff[0] != 1);

        System.out.println("Ready");

        for(int i = 0; i < 10; i++)
        {
            comm.writeBytes(new byte[]{0,1},2);
        }

        comm.closePort();
    }
}
