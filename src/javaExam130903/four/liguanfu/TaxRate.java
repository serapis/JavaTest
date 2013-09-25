package javaExam130903.four.liguanfu;

import exam.four.ITaxRate;

/**
 * 税率类:请设计出合理的税率类（TaxRate）以便于完成税率业务，并方便前台灵活配置税率信息；
 * TODO:请完成此类的设计
 */


public class TaxRate implements ITaxRate {
    double maxMoney = 0;
    double taxRate = 0;
    double minMoney = 0;

    public double getMinMoney() {
        return minMoney;
    }

    private void setMinMoney(double minMoney) {
        this.minMoney = minMoney;
    }

    public double getTaxRate() {
        return taxRate;
    }

    private void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getMaxMoney() {
        return maxMoney;
    }

    private void setMaxMoney(double maxMoney) {
        this.maxMoney = maxMoney;
    }

    TaxRate(double min, double max, double rate) {
        if (max >= 0 && min >= 0) {
            if (max >= min) {
                setMaxMoney(max);
                setMinMoney(min);
            }
        }

        if (rate >= 0 && rate <= 1) {
            setTaxRate(rate);
        }
    }


    public double quickCount(double salary) {
        double quickResult = 0;
        if (maxMoney > minMoney) {
            if (salary < maxMoney) {
                quickResult = (salary - minMoney) * taxRate;
                return quickResult;
            } else {
                quickResult = (maxMoney - minMoney) * taxRate;
                return quickResult;
            }
        }
        if (maxMoney == minMoney) {
            quickResult = (salary - maxMoney) * taxRate;
            return quickResult;
        }
        return 0;
    }


}
