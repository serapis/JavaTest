package javaExam130903.four;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: liguanfu
 * Date: 13-9-1
 * Time: 下午6:05
 * To change this template use File | Settings | File Templates.
 */
public interface ITaxRateManager {
    double computeTax(double salary, List<ITaxRate> taxRateList);
}
