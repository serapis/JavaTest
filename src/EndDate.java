import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Guanfu on 13-8-29.
 */
public class EndDate {
    //检查日期合法性
    Date beginDate() {


        return null;
    }

    //计算过期日期及过期前两周日期

    Date twoWeeksAgo() {


        return null;
    }


    //判定两周前是否为星期五
    //       是：输出日期；
    //       否：求出之前最近的星期五。

    Date isFriday() {


        return null;
    }


    public static String getWeekday(String date) {//必须yyyy-MM-dd

        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat sdw = new SimpleDateFormat("E");

        Date d = null;

        try {

            d = sd.parse(date);

        } catch (ParseException e) {

            e.printStackTrace();

        }

        return sdw.format(d);

    }

}
