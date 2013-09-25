package machineID;

/**
 * Created by Guanfu on 13-9-5.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author OnlyFor_love
 * @version 1.0
 */
public class MACAddress {
    public MACAddress() {
    }

    public static String getMACAddress() {

        String address = "";
        String os = System.getProperty("os.name");
        if (os != null && os.startsWith("Windows")) {
            try {
                String command = "cmd.exe /c ipconfig /all";
                Process p = Runtime.getRuntime().exec(command);
                BufferedReader br =
                        new BufferedReader(
                                new InputStreamReader(p.getInputStream()));
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.indexOf("Physical Address") > 0) {
                        int index = line.indexOf(":");
                        index += 2;
                        address = line.substring(index);
                        break;
                    }
                }
                br.close();
                return address.trim();
            } catch (IOException e) {}
        }
        return address;
    }

    /**
    public String getCpu()
    {
        String strCpu = null;
        ManagementClass myCpu = new ManagementClass("win32_Processor");
        ManagementObjectCollection myCpuConnection = myCpu.GetInstances();
        foreach( ManagementObject myObject in myCpuConnection)
        {
            strCpu = myObject.Properties["Processorid"].Value.ToString();
            break;
        }
        return strCpu;

    }
**/
    public static void main(String[] args) {
        System.out.println(""+MACAddress.getMACAddress());
    }
}