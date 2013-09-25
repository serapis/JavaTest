package javaExam130903.four.liguanfu;

import exam.four.ITaxRate;
import exam.four.ITaxRateManager;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 下午6:06
 * To change this template use File | Settings | File Templates.
 */



public class TaxRateManager implements ITaxRateManager {


    public static void main(String[]args)
    {

        List<ITaxRate> taxRateList=new ArrayList<ITaxRate>();

        TaxRateManager ceshi=new TaxRateManager();

        taxRateList.add(0,new TaxRate(0,850,0));
        taxRateList.add(1,new TaxRate(850,1350,0.05));
        taxRateList.add(2,new TaxRate(1350,2850,0.1));
        taxRateList.add(3,new TaxRate(2850,5850,0.15));
        taxRateList.add(4,new TaxRate(5850,5850,0.2));
        double result=ceshi.computeTax(7000,taxRateList);
        System.out.println("工资为7000");
        System.out.println("个人所得税为"+result);








    }

    @Override
    /***
     * TODO:请完成此方法
     * 在税率业务类TaxRateManager中完成computeTax(double salary,List< TaxRate > taxRateList)方法，此方法用来计算个人所得税
     * 注：
     a)	传入的taxRateList可能是乱序的（即未按1350、2850这样的顺序排序），请考虑！！
     b)	职工的月薪和应交的个人所得税，都是精确到分的；
     */
    public double computeTax(double salary, List<ITaxRate> taxRateList) {
        //我设计的是如果minMoney和maxMoney相等且minMoney是List中最大的，那么这个范围就是minMoney到无穷大
        //把税表中的minMoney取出来与工资比较，minMoney高于工资的那些条可以不考虑
        double[] minMoney=new double[taxRateList.size()];
        double taxMoney=0;//一共要交的税金
        //累加快速计算值
        for(int i=0;i<taxRateList.size();i++){
            //minMoney[i]=((TaxRate)taxRateList.get(i)).getMinMoney();
            if(((TaxRate)taxRateList.get(i)).getMinMoney()<=salary){
                taxMoney=taxMoney+((TaxRate)taxRateList.get(i)).quickCount(salary);
            };

        }

       // Arrays.sort(minMoney);


        //保留两位小数
        DecimalFormat df=new DecimalFormat(".##");
        return  Double.valueOf(df.format(taxMoney));


    }
}
