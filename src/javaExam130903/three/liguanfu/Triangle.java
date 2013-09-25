package javaExam130903.three.liguanfu;

import exam.three.ITriangle;

import java.text.DecimalFormat;
import java.util.Arrays;

/**
 * 三角形
 */
public class Triangle implements ITriangle {

    /**
     * 用来测试的方法请不要修改！！！！！！！！！！！！！！！！
     *
     * @param args
     */
    public static void main(String[] args) {
        //不正确的三角形测试

        try {
            Triangle wrong = new Triangle(1, 2, 3);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        //正确的三角形测试
        Triangle a = null;
        try {
            a = new Triangle(31, 25, 30);
        } catch (Exception e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        System.out.println(a.computeBT());
    }

    /**
     * TODO：请完成此构造方法
     *
     * @param a
     * @param b
     * @param c

     */
    double aa=0;
    double bb=0;
    double cc=0;
    public Triangle(double a, double b, double c) throws Exception {
        //三边放入数组，数组升序排序，最大边小于另两边之和则能组成三角形,且三个边均大于零
        double[] line={a,b,c};
        Arrays.sort(line);
        if(a>0&&b>0&&c>0){
        if((line[1]+line[0])>line[2]){

            System.out.println("");

        }else {
            throw new Exception("不能组成三角形");
        }
        }else{ throw new Exception("不能组成三角形，三边均需大于零");}

        aa=a;
        bb=b;
        cc=c;
    }


    /**
     * 以最长边上的高为边的全等三角形的面积+其他两边组成的长方形的对角线*最长边上的高
     * TODO：请完成此方法
     *
     * @return
     */
    public double computeBT() {

        double[] line={aa,bb,cc};
        Arrays.sort(line);
        if((line[1]+line[0])>line[2]){
            //@param area2 三角形面积的平方
            double s=(aa+bb+cc)/2;
            double area2=s*(s-aa)*(s-bb)*(s-cc);

            //line2Area2长边的全等三角形的面积
            double sLine2=(line[2]+line[2]+line[2])/2;
            double line2Area2=sLine2*(sLine2-line[2])*(sLine2-line[2])*(sLine2-line[2]);

            //其他两边组成的长方形的对角线
            //@param diagonal2 对角线的平方
            double diagonal2=line[1]*line[1]+line[0]*line[0];

            //最长边上的高可由公式：面积=（底*高）/2  求出
            //@param high2 最长边上高的平方
            double high2=4*area2/(line[2]*line[2]);

            //当前三角形的特殊面积值
            //@param specialArea 当前三角形的特殊面积值
            double specialArea=Math.sqrt(line2Area2)+Math.sqrt(high2*diagonal2);


            //结果保留两位小数
            DecimalFormat df=new DecimalFormat(".##");
            return  Double.valueOf(df.format(specialArea));

    }
        return 0;}
    }
