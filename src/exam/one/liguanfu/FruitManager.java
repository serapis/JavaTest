package exam.one.liguanfu;

import exam.one.IFruit;
import exam.one.IFruitManager;

import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
public class FruitManager implements IFruitManager {
    /**
     * 最终测试用的代码，请不要修改！！！！！！！！！
     *
     * @param args
     */
    public static void main(String[] args) {
        Map<Integer, Double> order = new HashMap<Integer, Double>();
        order.put(1, 45.00);
        order.put(2, 30.51);
        order.put(3, 6.00);
        order.put(4, 500.00);
        order.put(5, 5000.00);
        List<IFruit> fruitList = new ArrayList<IFruit>();
        IFruit aFruit = new Fruit();
        aFruit.setId(1);
        aFruit.setName("苹果");
        aFruit.setInventory(50D);
        aFruit.setUnitPrice(3.02);
        fruitList.add(aFruit);
        aFruit = new Fruit();
        aFruit.setId(2);
        aFruit.setName("香蕉");
        aFruit.setInventory(100.00);
        aFruit.setUnitPrice(10.11);
        fruitList.add(aFruit);
        aFruit = new Fruit();
        aFruit.setId(3);
        aFruit.setName("西瓜");
        aFruit.setInventory(300.00);
        aFruit.setUnitPrice(2.56);
        fruitList.add(aFruit);
        aFruit = new Fruit();
        aFruit.setId(4);
        aFruit.setName("西瓜");
        aFruit.setInventory(10.00);
        aFruit.setUnitPrice(4.78);
        fruitList.add(aFruit);
        FruitManager fruitManager = new FruitManager();

        System.out.print(fruitManager.computeAmount(order, fruitList));
    }

    @Override
    /***
     * 接收这个订单（order）和当前的水果信息（fruitList），返回这笔订单的总金额(精确到分)，并修改水果库存
     * TODO:请完成此题目
     */
    public double computeAmount(Map<Integer, Double> order, List<IFruit> fruitList)
    {
        double [] sumMoney=new double[order.size()];
        double totalMoney=0;


        //通过ID找库存：先遍历order用其中每一个ID在fruitList中查找其库存，fruitList中不存在此ID则忽略此ID



        //比较同一ID下，fruitLsit中库存和order中的出货量




        //unitPrice乘以出货量，结果存到总价数组










        //求出总价数组所有元素之和，保留两位小数后当做返回值
        for(double i:sumMoney)
        {
            totalMoney=totalMoney+i;
        }

        return totalMoney    ;
    }
}

