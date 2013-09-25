import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Guanfu on 13-8-29.
 */
public class lianxi {


    /**
     * 13、字符串替换
     * 输入一行字符串，生成一个新的字符串，
     * 将原字符串中的大写字母用下面列出的对应大写字母替换, 其余字符不变, 输出新字符串.
     * 原字母   对应字母
     * A ──→ Z
     * B ──→ Y
     * C ──→ X
     * D ──→ W
     * ……
     * X ──→ C
     * Y ──→ B
     * Z ──→ A
     * 例：括号内是说明
     * 3次分别的输入：
     * A flag of USA
     * IT12
     * oueiaba
     * 3次分别的输出：
     * Z flag of FHZ
     * RG12
     * oueiaba
     * <p/>
     * 把要替换的字符存入数组
     * 便利数组，改成相应的
     */


    public void thirdteen(String yuanshuju) {

        char[] chars = yuanshuju.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] <= 90 && (int) chars[i] >= 65) {
                int acs = 90 - ((int) chars[i] - 65);
                chars[i] = (char) Integer.parseInt(String.valueOf(acs));
                //System.out.print(" "+chars[i]+" "+(int)chars[i]);
            }
            System.out.print(chars[i]);
        }
        System.out.println("");
    }


    /**
     * 12、统计大写辅音字母
     * 输入一行字符串，统计并输出字符串中大写辅音字母的个数
     * (大写辅音字母:除“A”,“E”,“I”,“O”,“U”以外的大写字母)。
     * 例：括号内是说明，不要求输出
     * 3次分别的输入：
     * HELLO
     * IT12
     * uieiaba
     * 3次分别的输出：
     * 3     ("HELLO"中有3个大写辅音字母)
     * 1    （"IT12"中有1个大写辅音字母）
     * 0    （"uieiaba"中没有大写辅音字母）
     * <p/>
     * <p/>
     * aeiou存入数组
     * 便利数组把字符串中的aeiou替换成空
     * 求剩下的字符串长度
     */

    public void twelve(String jiance) {
        String[] yuanyin = {"A", "E", "I", "O", "U"};
        for (String a : yuanyin) {
            jiance = jiance.replaceAll(a, "");
            // replaceString(jiance,a,"");
        }
        int numss = 0;
        char[] chars = jiance.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if ((int) chars[i] <= 90 && (int) chars[i] >= 65) {
                numss++;
            }
        }
        System.out.println(numss);
    }


    public static void replaceString(String source, String oldStr, String newStr) {

        //System.out.println(source);

        String result = source.replaceAll("(?i)" + oldStr, newStr); //大小写不敏感

        // System.out.println(result);

        System.out.println(source.replaceAll(oldStr, newStr));//大小写敏感

    }


    /**
     * 11、交换最小值和最大值
     * 输入为一个正整数数组，如果某一个数出现两次，仅保留第一次，例如输入为1 2 3 3 2 5，去掉后的结果是1 2 3 5
     * 并将其最小值和最大值的位置互换，例如输入为1 2 3 3 2 5，去掉并交换后的结果是5 2 3 1
     * <p/>
     * xian qu chong fu
     * <p/>
     * <p/>
     * zai jiaohuan
     */


    public void eleven(int[] intArray) {
        Set<Integer> set1 = new HashSet<Integer>();
        for (int a : intArray) {
            set1.add(a);
        }

        int minNum = 0;
        int minIndex = 0;
        int maNum = 0;
        int maxIndex = 0;


        Iterator<Integer> iter = set1.iterator();
        while (iter.hasNext()) {
            int str = iter.next();
            System.out.print(str);
        }


    }


    public void eleven22(int[] intArray) {
        for (int i = 0; i < intArray.length; i++) {

            for (int j = i + 1; j < intArray.length; j++) {
                if (intArray[j] == intArray[i]) {


                }


            }


        }


    }


    public static void testA(String[] str) {

        for (String elementA : str) {
            System.out.print(elementA + " ");
        }
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < str.length; i++) {
            if (!list.contains(str[i])) {
                list.add(str[i]);
            }
        }

        System.out.println();
        String[] newStr = list.toArray(new String[1]); //返回一个包含所有对象的指定类型的数组
        for (String elementB : newStr) {
            System.out.print(elementB + " ");
        }
        System.out.println();
    }


    /**
     * 10、求最大值及其下标
     * 输入为一个正整数数组，请求出其中的最大值及其下标
     * <p/>
     * 便利数组，和最大数比较
     */
    public void ten(int[] tenIntString) {
        int max = tenIntString[0];
        int indnum = 0;
        for (int i = 0; i < (tenIntString.length - 1); i++) {
            if (tenIntString[i] < tenIntString[i + 1]) {
                max = tenIntString[i + 1];
                indnum = i + 1;
            }

        }

        System.out.println("The max number is: " + max + "/n" + "It's index is: " + indnum);

    }


    /**
     * 9、写出一段代码求出前N个立方和数
     * 立方和数定义：各位数字的立方和等于它本身的数
     * 如：
     * 153 (1*1*1+5*5*5+3*3*3=153)
     * 370 (3*3*3+7*7*7=370)
     * 371 (3*3*3+7*7*7+1*1*1=371)
     */
    public int nine(int n, int geshu) {


        int nn = 0;
        String JString = String.valueOf(n);
        char[] chars = JString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            nn = nn + (Integer.parseInt(String.valueOf(chars[i]))) * (Integer.parseInt(String.valueOf(chars[i]))) * (Integer.parseInt(String.valueOf(chars[i])));

        }
        if (nn == n) {
            System.out.println(n);
            return geshu + 1;
        } else {
            return geshu;
        }


    }

    //nine2参数为正整数
    public void nine2(int n) {

        int geshu = 1;
        int num = 0;
        while (geshu <= n) {
            geshu = this.nine(num, geshu);
            num++;


        }


    }


    /**
     * 8、求输入两个正整数，第一个是要循环的1-9之间的数a，第二个是要循环的次数n，求a+aa+aaa+aa…a，
     * 输入a=2,n=3
     * 输出246（即2+22+222）
     * <p/>
     * int 结果=0；
     * for（i=1,i<=n）
     * {
     * String []  linshi=new String[n]；
     * <p/>
     * for(){}  //给数组每元素赋值a
     * 数组转字符串再转数值
     * <p/>
     * 结果=结果+数组的值
     * <p/>
     * }
     */
    public void eight(int shu, int cishu) {
        int jieguo = shu;
        String shuString = String.valueOf(shu);
        for (int i = 1; i < cishu; i++) {
            shuString = shuString + String.valueOf(shu);
            jieguo = jieguo + Integer.parseInt(shuString);
        }
        System.out.println("The result is: " + jieguo);
    }


    /**
     * 7、求整数的位数以及各位数之和
     * <p/>
     * 放入数组，求数组长度，数组从头家到位
     */
    public void seven(int zhengshu) {
        String shuString = String.valueOf(zhengshu);
        char[] chars = shuString.toCharArray();
        System.out.println("Number's length is " + chars.length);
        int he = 0;
        for (int i = 0; i < chars.length; i++) {
            he = he + Integer.parseInt(String.valueOf(chars[i]));
        }
        System.out.println("sum is " + he);

    }


    /**
     * 6、计算个人所得税
     * 输入一个职工的月薪salary，输出应交的个人所得税tax。
     * salary <= 850 部分的rate = 0%;
     * 850 < salary <= 1350 部分的rate = 5%;即tax = rate * (salary-850)
     * 1350 < salary <= 2850 部分的rate = 10%;
     * 2850 < salary <= 5850 部分的rate = 15%;
     * 5850 < salary 部分的rate = 20%;
     * <p/>
     * <p/>
     * <p/>
     * <p/>
     * <p/>
     * <p/>
     * <p/>
     * 按照国家最新修订的《个人所得税法》，个税起征点确定为3500元，适用超额累进税率为3%至45%。7级超额累进税率如下表：
     * <p/>
     * 全月应纳税所得额	 税率	 速算扣除数(元)
     * 全月应纳税额不超过1500元	 3%	 0
     * 全月应纳税额超过1500元至4500元	 10%	 105
     * 全月应纳税额超过4500元至9000元	 20%	 555
     * 全月应纳税额超过9000元至35000元	 25%	 1005
     * 全月应纳税额超过35000元至55000元	 30%	 2755
     * 全月应纳税额超过55000元至80000元	 35%	 5505
     * 全月应纳税额超过80000元	 45%	 13505
     * <p/>
     * 个税的具体算法：
     * 1、确定税率及速算扣除数
     * 在上面的7级超额累进税率表中，找到相对应的税率及对应速算扣除数
     * 2、算出纳税额度
     * 纳税额度＝月收入（扣除三险后的）- 3500元（个税起征点）
     * 3、算出个税
     * 个税＝应纳税额×对应的税率-速算扣除数
     * <p/>
     * <p/>
     * 判定工资减去3500后在哪个档
     * 乘以税率再减去速算扣除数
     */
    public void six(double geshuiqizhengdian) {


    }


    /**
     * 5、求三角形的面积和周长
     * 输入三角形的三条边的值a, b, c，如果能构成一个三角形，输出面积area+最长边上的高的平方；
     * 否则，输出“不能组成三角形”。
     * 在一个三角形中，任意两边之和大于第三边。
     * 三角形的面积计算公式：area*area = s(s-a)(s-b)(s-c)
     * 其中:s = (a+b+c)/2
     * 输出要求：精确到小数点后2位
     */

    public void five(int a, int b, int c) {

        int[] bian = {a, b, c};
        //biger
        Arrays.sort(bian);
        if ((bian[1] + bian[0]) > bian[2]) {
            //double?
            double aa = a;
            double bb = b;
            double cc = c;
            double s = (aa + bb + cc) / 2;
            double area2 = s * (s - aa) * (s - bb) * (s - cc);
            System.out.println("面积" + String.format("%.2f", Math.sqrt(area2)));
            System.out.println("最长边上的高的平方" + String.format("%.2f", (4 * area2 / (bian[2] * bian[2]))));


        } else {
            System.out.println("不能组成三角形");
        }


    }


    DecimalFormat df = new DecimalFormat("#.00");


    /**
     * 4、计算存款利息
     * 输入存款金额 money、存期 year 和年利率 rate，
     * 根据下列公式计算存款到期时的利息 interest(税前)，输出时保留2位小数。
     * interest = money(1+rate)^year - money
     * 输入输出示例：括号内为说明
     * 输入参数
     * 1000 3 0.025	(money = 1000, year = 3, rate = 0.025)
     * 输出
     * interest = 76.89
     */
    public void four(double money, int year, double rate) {


        double interest;
        interest = money * (Math.pow((1 + rate), year)) - money;

        System.out.println(String.format("%.2f", interest));
    }


    /**
     * 3.数字加密
     * 输入1个四位数，将其加密后输出。
     * 方法是将该数每一位上的数字加9，
     * 然后除以10取余，做为该位上的新数字，
     * 最后将第1位和第3位上的数字互换，第2位和第4位上的数字互换，组成加密后的新数。
     * 例：括号内是说明
     * 输入
     * 1257
     * 输出
     * 4601
     */

    public void three(int shu) {
        String shuString = String.valueOf(shu);
        char[] chars = shuString.toCharArray();
        String[] jieguo = new String[4];
        for (int i = 0; i < chars.length; i++) {
            int linshi = (Integer.parseInt(String.valueOf(chars[i])) + 9) % 10;
            jieguo[i] = String.valueOf(linshi);


        }

        String[] jieguo2 = new String[4];

        jieguo2[0] = jieguo[2];
        jieguo2[2] = jieguo[0];
        jieguo2[1] = jieguo[3];
        jieguo2[3] = jieguo[1];


        for (String a : jieguo2) {
            System.out.print(a);
        }
    }


    /**
     * 2.计算旅途时间
     * 输入2个"yyyymmddhhmm"格式的整数time1和time2，表示火车的出发时间和到达时间，计算并输出旅途时间。
     * 如果字符串格式不正确或出发时间晚于到达时间的情况，抛出异常；
     * 例：括号内是说明
     * 输入
     * 201301010712 201301011411（出发时间是2013年1月1日7点10分，到达时间是2013年1月1日14点11分）
     * 输出
     * 6 小时 59 分钟
     */
    public void two(String yuanshuju) throws ParseException {

        DateFormat format = new SimpleDateFormat("yyyyMMddHHmm");
        Date dDate = format.parse("2009111200");
        DateFormat format2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String reTime = format2.format(dDate);
        System.out.println(reTime);

    }


    /**
     * 1.显示一句英语的单词首字母（空格数可以是多个），无论大写小写都转换为大写
     * 例：输入
     * I'm coming,my dear.
     * 输出
     * ICMD
     */
    public void one(String juzi) {
        char[] chars = juzi.toCharArray();
        String[] jieguo = new String[20];
//        String [] shibie={" ",",",":",";","\"","\'"};
        String[] shibie = {" ", ",", ":", ";"};
        jieguo[0] = String.valueOf(chars[0]);
        int k = 1;
        for (int i = 1; i < chars.length; i++) {
            for (int j = 0; j < shibie.length; j++) {
                if (String.valueOf(chars[i]).equals(shibie[j])) {
                    if ((int) chars[i + 1] >= 97 && (int) chars[i + 1] <= 122) {
                        jieguo[k] = String.valueOf((char) ((int) chars[i + 1] - 32));
                        k++;

                    } else {
                        jieguo[k] = String.valueOf(chars[i + 1]);
                        k++;
                    }
                }
            }
        }

        for (String c : jieguo) {

            if (c.equals(null)) {
            } else {
                System.out.print(c);
            }
        }

    }


}
