package computerMD; /**
 * Created by Guanfu on 13-9-6.
 */

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;


public class HardWareUtils {


    /**
     * 获取主板序列号
     *
     * @return
     */
    public static String getMotherboardSN() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);


            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";


            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result.trim();
    }

    /**
     * 获取CPU序列号
     *
     * @return
     */
    public static String getCPUSerial() {
        String result = "";
        try {
            File file = File.createTempFile("tmp", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new FileWriter(file);
            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_Processor\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.ProcessorId \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";
            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
            file.delete();
        } catch (Exception e) {
            e.fillInStackTrace();
        }
        if (result.trim().length() < 1 || result == null) {
            result = "无CPU_ID被读取";
        }
        return result.trim();
    }



    public static void main(String[] args) {
        System.out.println("CPU  SN:"+HardWareUtils.getCPUSerial());
        System.out.println("主板 SN:"+HardWareUtils.getMotherboardSN());
        md5s(filterGetString(getMotherboardSN()));


    }





    public static String filterGetString(String snNumber)
    {
        char[]chars=snNumber.toCharArray();
        List<String> result=new ArrayList<String>();
//
        for(int i=0;i<chars.length;i++)
        {
            if( ((int)chars[i]<=90&&(int)chars[i]>=65)||((int)chars[i]<=57&&(int)chars[i]>=48)||( (int)chars[i]<=122&&(int)chars[i]>=97  )  )
            {
                result.add(String.valueOf(chars[i]));


            }

        }
        String numLetter="";
        for(String a:result)
        {
            numLetter=numLetter+a;

        }
        return numLetter;
    }



    public static void md5s(String plainText) {String str1;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(plainText.getBytes());
            byte b[] = md.digest();

            int i;

            StringBuffer buf = new StringBuffer("");
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            str1 = buf.toString();
            System.out.println("MD5加密主板SN，32位结果: " + buf.toString());// 32位的加密
            System.out.println("MD5加密主板SN，16位结果: " + buf.toString().substring(8, 24));// 16位的加密

        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();

        }

    }

}
