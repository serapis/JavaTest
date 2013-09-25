package exam.one;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 上午9:21
 * To change this template use File | Settings | File Templates.
 */
public interface IFruitManager {
    double computeAmount(Map<Integer, Double> order, List<IFruit> fruitList);
}
