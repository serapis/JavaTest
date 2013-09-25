package javaExam130903.two.liguanfu;

import exam.two.IHolidayManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午10:26
 * To change this template use File | Settings | File Templates.
 */
public class HolidayManager implements IHolidayManager {
    /**
     * 最终测试用的代码，请不要修改！！！！！！！！！
     *
     * @param args
     */
    public static void main(String[] args) {

        try {
            System.out.print("测试格式用的代码:");
            new HolidayManager().returnHolidayDateBetweenTwoDateStr("20130501", "20130701");
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        System.out.println();
        //测试起始日期早晚用的代码
        try {
            System.out.print("测试起始日期早晚用的代码:");
            new HolidayManager().returnHolidayDateBetweenTwoDateStr("2013-05-01", "2013-04-01");
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
        System.out.println();
        //测试正确结果用的代码
        try {
            System.out.print("测试正确结果用的代码:");
            String[] a = new HolidayManager().returnHolidayDateBetweenTwoDateStr("2013-05-01", "2013-07-01");
            System.out.println("一共有" + a.length + "个假日");
            for (String s : a) {
                System.out.println(s);
            }
        } catch (Exception ex) {
            System.out.print(ex.getMessage());
        }
    }

    @Override
    /**
     * 返回指定日期之间的所有节假日的"yyyy-MM-dd"形式的字符串数组
     * TODO:请完成此方法
     * （1）所有的周末；
     * （2）10.1黄金周七天
     * （3）5.1放假3天
     * （4）母亲节（每年五月的第二个星期日是母亲节）
     * （5）父亲节（每年六月的第三个星期日是父亲节）；
     */
    public String[] returnHolidayDateBetweenTwoDateStr(String beginDateStr, String endDateStr) throws Exception {
        //把开始日期和结束日期转换成日期格式
        Date beginDate = null;
        Date endDate = null;
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

        try {
            beginDate = sd.parse(beginDateStr);
            endDate = sd.parse(endDateStr);
        } catch (ParseException e) {
            //抛出格式异常
            e.printStackTrace();

        }


        //计算出开始和结束间经历的日期，把日期存入period[]


        List<Date> period = new ArrayList<Date>();
        int i = 0;
        Calendar daycal = new GregorianCalendar();
        daycal.setTime(beginDate);
        Date today = beginDate;


        //判定结束日期和开始日期的大小
        if (endDate.before(beginDate)) {
            System.out.println("结束日期比开始日期早");
        }
        while (today.before(endDate)) {
            period.add(i, today);
            daycal.add(Calendar.DATE, 1);
            today = daycal.getTime();
            i++;

            //(new SimpleDateFormat("yyyy-MM-dd")).format(begincal.getTime())
        }

        //防止开始日期与结束日期是同一天
        if (period.get(i - 1) != today) {
            //把结束日期加进去
            period.add(i, today);
        }

        //测试用代码
        //for(int u=0;u<period.size();u++){System.out.println(period.get(u));}


        //把日期转换成星期几,并判断是否为周末
        List<Date> holidayResult = new ArrayList<Date>();
        int k = 0;
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        SimpleDateFormat monthAndDay = new SimpleDateFormat("MM-dd");


        for (int j = 0; j < period.size(); j++) {
            String day = sdw.format(period.get(j));
            String tenFiveDateString = monthAndDay.format(period.get(j));
            if (day.equals("星期日") || day.equals("星期六")) {
                holidayResult.add(k, period.get(j));
                k++;
            }


            //是否为十一或五一假期
            else if (tenFiveDateString.equals("10-02") || tenFiveDateString.equals("10-01") || tenFiveDateString.equals("10-03") || tenFiveDateString.equals("10-04") || tenFiveDateString.equals("10-05") || tenFiveDateString.equals("10-06") || tenFiveDateString.equals("10-07") || tenFiveDateString.equals("05-01") || tenFiveDateString.equals("05-02") || tenFiveDateString.equals("05-03")) {
                holidayResult.add(k, period.get(j));
                k++;


            }


            //判定是否为母亲节
            else if (mothersDay2(period.get(j))) {
                holidayResult.add(k, period.get(j));
                k++;
            }

             //判定是否为父亲节
             else if(fathersDay(period.get(j))){holidayResult.add(k,period.get(j));
             k++;}



        }


        //把结果改成String数组
        String[] resultString = new String[holidayResult.size()];

        for (int l = 0; l < holidayResult.size(); l++) {
            resultString[l] = sd.format(holidayResult.get(l));


        }


        return resultString;
    }

    //我觉得最优算法应该是生成开始和结束日期，所经历年份的父亲节和母亲节，判定这些日期是否在经历的日期内，再把他们加入结果数组
    //时间有限就不改了





    //判定输入日期是否为母亲节
    public static boolean mothersDay2(Date dayDate) throws ParseException {
        SimpleDateFormat monthersDayYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sdw = new SimpleDateFormat("E");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");


        //取得传入日期年份，从五月一日开始遍历，寻找第二个周四
        String motherYear = monthersDayYear.format(dayDate);

        Calendar daycal = new GregorianCalendar();

        String yymmdd = motherYear + "-05-01";

        daycal.setTime(sd.parse(yymmdd));

        int k = 0;
        int daycount = 0;
        for (int i = 0; i < 30; i++) {
            daycal.add(Calendar.DATE, k);
            if (sdw.format(daycal.getTime()).equals("星期四")) {

                daycount++;
                if (daycount == 2) {
                    if (dayDate.equals(daycal.getTime())) {
                        return true;
                    }
                }

            }
            k = 1;

        }

        return false;
    }

    //判定是否为父亲节
    //原理同母亲节判定
    public static boolean fathersDay(Date dayDate) throws ParseException {
        SimpleDateFormat fathersDayYear = new SimpleDateFormat("yyyy");
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat sdwfather = new SimpleDateFormat("E");


        String fatherYear = fathersDayYear.format(dayDate);

        Calendar fatherdaycal = new GregorianCalendar();



        String yymmdd = fatherYear + "-06-01";
        fatherdaycal.setTime(sd.parse(yymmdd));


        int k = 0;
        int daycount = 0;
        for (int i = 0; i < 30; i++) {
            fatherdaycal.add(Calendar.DATE, k);
            if (sdwfather.format(fatherdaycal.getTime()).equals("星期四")) {

                daycount++;
                if (daycount == 3) {
                    if (dayDate.equals(fatherdaycal.getTime())) {
                        return true;
                    }
                }

            }

            k=1;
        }

        return false;
    }

}
