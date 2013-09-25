package javaExam130903.one;

import exam.one.*;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public interface IFruitManager {
    double computeBatchAmount(List<IOrder> orderList, List<exam.one.IFruit> fruitList);
}
