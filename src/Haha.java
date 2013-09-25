import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.EventObject;

/**
 * Created by Serapis on 13-9-7.
 */
public class Haha {
    public Haha( ){
        int i;
        System.out.println();

    }

    public static double[] aaa(double he,double cha)
    {
        double[] results=new double[2];



        double x=(he+cha)/2;
        double y=he-x;

        return results;
    }

    public static double addnum (double he,double... cha)
    {
//        double[] results=new double[2];


double he2=0;
        for(double c:cha)
        {

            he2=he2+c;
        }
        he2=he+he2;
        return he2;
    }

    public static void main(String[] args) {
        System.out.println(addnum(5, 7, 1, 11, 1, 1, 1, 1, 1, 1, 1, 1));

    }

}