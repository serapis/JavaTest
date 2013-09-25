package javaExam130903.one.liguanfu;

import exam.one.IFruit;
import exam.one.IFruitManager;
import exam.one.IOrder;
import exam.one.liguanfu.*;

import java.text.DecimalFormat;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午9:19
 * To change this template use File | Settings | File Templates.
 */
public class FruitManager implements IFruitManager {
    public static void main(String[] args) {
        List<IOrder> iOrderList = new ArrayList<IOrder>();
        IOrder order = null;
        Map<Integer, Double> orderDetail = null;
        orderDetail = new HashMap<Integer, Double>();
        orderDetail.put(1, 145.00);
        orderDetail.put(2, 30.51);
        orderDetail.put(3, 6.00);
        orderDetail.put(4, 42.00);
        orderDetail.put(5, 5000.00);
        order = new PersonalOrder();
        order.setId(1L);
        order.setCreateTime(new Date(112, 2, 1, 12, 0, 0));
        order.setDetail(orderDetail);
        iOrderList.add(order);

        orderDetail = new HashMap<Integer, Double>();
        orderDetail.put(1, 254.00);
        orderDetail.put(2, 3.00);
        orderDetail.put(4, 17.00);
        order = new EnterpriseOrder();
        order.setId(4L);
        order.setCreateTime(new Date(112, 2, 1, 13, 0, 0));
        order.setDetail(orderDetail);
        iOrderList.add(order);

        orderDetail = new HashMap<Integer, Double>();
        orderDetail.put(2, 36.51);
        orderDetail.put(3, 6.00);
        orderDetail.put(4, 50.00);
        order = new EnterpriseOrder();
        order.setId(5L);
        order.setCreateTime(new Date(112, 2, 1, 10, 0, 0));
        order.setDetail(orderDetail);
        iOrderList.add(order);

        orderDetail = new HashMap<Integer, Double>();
        orderDetail.put(1, 150.00);
        orderDetail.put(2, 3.00);
        orderDetail.put(3, 13.00);
        orderDetail.put(4, 25.00);
        order = new PersonalOrder();
        order.setId(2L);
        order.setCreateTime(new Date(112, 2, 1, 13, 0, 0));
        order.setDetail(orderDetail);
        iOrderList.add(order);

        orderDetail = new HashMap<Integer, Double>();
        orderDetail.put(1, 36.51);
        orderDetail.put(4, 16.15);
        orderDetail.put(2, 6.00);
        orderDetail.put(3, 25.00);
        order = new EnterpriseOrder();
        order.setId(3L);
        order.setCreateTime(new Date(112, 2, 1, 10, 0, 0));
        order.setDetail(orderDetail);
        iOrderList.add(order);

        List<IFruit> fruitList = new ArrayList<IFruit>();
        IFruit aFruit = new exam.one.liguanfu.Fruit();
        aFruit.setId(1);
        aFruit.setName("苹果");
        aFruit.setInventory(500.00);
        aFruit.setUnitPrice(3.02);
        fruitList.add(aFruit);
        aFruit = new exam.one.liguanfu.Fruit();
        aFruit.setId(2);
        aFruit.setName("香蕉");
        aFruit.setInventory(100.00);
        aFruit.setUnitPrice(10.11);
        fruitList.add(aFruit);
        aFruit = new exam.one.liguanfu.Fruit();
        aFruit.setId(3);
        aFruit.setName("西瓜");
        aFruit.setInventory(300.00);
        aFruit.setUnitPrice(2.56);
        fruitList.add(aFruit);
        aFruit = new exam.one.liguanfu.Fruit();
        aFruit.setId(4);
        aFruit.setName("西瓜");
        aFruit.setInventory(100.00);
        aFruit.setUnitPrice(4.78);
        fruitList.add(aFruit);
        FruitManager fruitManager = new FruitManager();

        System.out.print("总金额是" + fruitManager.computeBatchAmount(iOrderList, fruitList));
        for (IOrder iOrder : iOrderList) {
            System.out.println("订单ID=" + iOrder.getId() + ",订单金额" + iOrder.getAmount());
        }
        for (IFruit iFruit : fruitList) {
            System.out.println("水果ID=" + iFruit.getId() + ",当前库存" + iFruit.getInventory());
        }
    }

    /**
     * TODO:请完成此方法的编写
     * 接收批量的订单（orderList）和当前的水果信息（fruitList），返回这笔订单的总金额(精确到分)，并修改水果库存和该笔订单的金额；
     *
     * @param orderList 批量的订单
     * @param fruitList 当前的水果信息
     * @return 这笔订单的总金额(精确到分)，并修改水果库存和该笔订单的金额；
     */
    @Override
    public double computeBatchAmount(List<IOrder> orderList, List<IFruit> fruitList) {
        double sumMoney = 0;

        //遍历fruitList,把ID存入数组
        Integer[] idList = new Integer[fruitList.size()];
        for (int i = 0; i < fruitList.size(); i++) {
            idList[i] = fruitList.get(i).getId();

        }
        //先遍历orderList


        for (IOrder a : orderList) {
            //遍历刚才的ID数组
            Map<Integer, Double> everyOrderDetial = new HashMap<Integer, Double>();
            for (int j = 0; j < idList.length; j++) {


                //遍历订单的detail
                everyOrderDetial = a.getDetail();
                //有相应的水果的话，通过ID知道idList的索引，而idList的索引与fruitList的索引是相通的，所以能查出该种水果相应的价格和库存
                for (Integer mapKey : everyOrderDetial.keySet()) {
                    //查看此条订单的detial信息中是否有相应水果
                    if (mapKey == idList[j]) ;
                    {
                        //有的话在fruitList中查找相应ID的库存量和单价，比较库存信息，修改fruitList中的库存信息

                        if (fruitList.get(j).getInventory() >= everyOrderDetial.get(mapKey)) {
                            fruitList.get(j).setInventory(fruitList.get(j).getInventory() - everyOrderDetial.get(mapKey));

                            //求出此种水果的销售额
                            a.setAmount(a.getAmount() + (everyOrderDetial.get(mapKey)) * fruitList.get(j).getUnitPrice());
                        } else {

                            a.setAmount(a.getAmount() + fruitList.get(j).getUnitPrice() * fruitList.get(j).getInventory());
                            ;
                        }

                        ;

                    }


                }


            }


        }


        //遍历完成后再遍历一边orderList中的amount，求和

        for (IOrder b : orderList) {
            sumMoney = b.getAmount() + sumMoney;

        }


        //保留两位小数
        DecimalFormat df = new DecimalFormat(".##");
        return Double.valueOf(df.format(sumMoney));
    }
}

