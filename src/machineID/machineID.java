package machineID;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * Created by Guanfu on 13-9-5.
 */
public class machineID {
    public static String getIp() {
        String localip = null;// 本地IP，如果没有配置外网IP则返回它
        String netip = null;// 外网IP
        try {
            Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
            InetAddress ip = null;
            boolean finded = false;// 是否找到外网IP
            while (netInterfaces.hasMoreElements() && !finded) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> address = ni.getInetAddresses();
                while (address.hasMoreElements()) {
                    ip = address.nextElement();
                    System.out.println(ni.getName() + ";" + ip.getHostAddress()
                            + ";ip.isSiteLocalAddress()="
                            + ip.isSiteLocalAddress()
                            + ";ip.isLoopbackAddress()="
                            + ip.isLoopbackAddress());
                    if (!ip.isSiteLocalAddress() && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 外网IP
                        netip = ip.getHostAddress();
                        finded = true;
                        break;
                    } else if (ip.isSiteLocalAddress()
                            && !ip.isLoopbackAddress()
                            && ip.getHostAddress().indexOf(":") == -1) {// 内网IP
                        localip = ip.getHostAddress();
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }
        if (netip != null && !"".equals(netip)) {
            return netip;
        } else {
            return localip;
        }
    }


    public static String getMacAddr() {
        try {
            Enumeration<NetworkInterface> em = NetworkInterface.getNetworkInterfaces();
            while (em.hasMoreElements()) {
                NetworkInterface nic = em.nextElement();
                //System.out.println ("nic.getDisplayName ():" + nic.getDisplayName ());
                //System.out.println ("nic.getName ():" + nic.getName ());
                byte[] b = nic.getHardwareAddress();
                if (b == null)
                    continue;
                StringBuilder builder = new StringBuilder();
                for (int i = 0; i < b.length; i++) {
                    builder.append(byteHEX(b[i]));
                    builder.append("-");
                }
                builder.deleteCharAt(builder.length() - 1);
                return builder.toString();
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }


    public static String getLocalIP() {
        String ip = "";
        try {
            Enumeration<?> e1 = (Enumeration<?>) NetworkInterface.getNetworkInterfaces();
            while (e1.hasMoreElements()) {
                NetworkInterface ni = (NetworkInterface) e1.nextElement();
                Enumeration<?> e2 = ni.getInetAddresses();
                while (e2.hasMoreElements()) {
                    InetAddress ia = (InetAddress) e2.nextElement();
                    ip = ia.getHostAddress();
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
            System.exit(-1);
        }
        return ip;
    }


    /* 一个将字节转化为十六进制ASSIC码的函数 */
    public static String byteHEX(byte ib) {
        char[] Digit =
                {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        char[] ob = new char[2];
        ob[0] = Digit[(ib >>> 4) & 0X0F];
        ob[1] = Digit[ib & 0X0F];
        String s = new String(ob);
        return s;
    }

    /**
    public static void main(String[] args) {
        System.out.println(getIp());
        System.out.println(getLocalIP());
       /**
         System.out.println(getMacAddr());
         System.out.println("");


    }
**/

}
