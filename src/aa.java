public class aa {
    public static void main(String[] args) {

/**
 Set set = new HashSet();
 set.add(1);
 set.add(1);
 set.add(1);
 set.add(1);

 System.out.println("set.size() = " + set.size());

 Iterator iter = set.iterator();

 while (iter.hasNext()) {
 Object next = iter.next();
 System.out.println("next = " + next);
 }
 **/


        String duibi = "'mr';delete from user where name='a'";
        //将危险字符存入数组
        String[] weixian = {"&", ";", "'", "<", ">", "-", "/", "%", "=", "#"};
        System.out.println(No1.weixianjiance(weixian, duibi));

        lianxi lianx1 = new lianxi();


        //No.13
        System.out.println("No.13");
        String s1 = "A flag of USA";
        String s2 = "IT12";
        String s3 = "oueiaba";
        lianx1.thirdteen(s1);
        lianx1.thirdteen(s2);
        lianx1.thirdteen(s3);


        //No.12
        System.out.println("No.12");
        String s121 = "HELLO";
        String s122 = "IT12";
        String s123 = "uieiaba";
        lianx1.twelve(s121);
        lianx1.twelve(s122);
        lianx1.twelve(s123);


        //No.11
        int[] s111 = {1, 2, 3, 3, 2, 5};
        System.out.println("No.11");
        lianx1.eleven(s111);


        //No.10
        System.out.println("No.10");


        //No.9
        System.out.println("No.9");
        //nine2参数为正整数
        lianx1.nine2(4);


        //No.8
        System.out.println("No.8");
        lianx1.eight(2, 3);


        //No.7
        System.out.println("No.7");
        lianx1.seven(224);


        //No.6
        System.out.println("No.6");


        //No.5
        System.out.println("No.5");
        lianx1.five(1, 4, 4);


        //No.4
        System.out.println("No.4");
        lianx1.four(1000, 3, 0.025);


        //No.3
        System.out.println("No.3");
        lianx1.three(1257);
        System.out.print("\n");


        //No.2
        System.out.println("No.2");


        //No.1
        System.out.println("No.1");
        lianx1.one("I'm coming,my dear.");
    }


}
