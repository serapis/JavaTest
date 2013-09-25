package javaExam130903.one.liguanfu;

import exam.one.IOrder;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO:请完成此类的编写
 * 个人用户订单除了要记录订单编码、订单产生时间、订单细节、订单总金额之外还要记录用户编码（整数类型），接单员编码（整数类型）
 */
public class PersonalOrder implements IOrder {
    Long id=Long.valueOf(0);
    double amount=0;
    Date createTime=null;
    Map<Integer, Double> detail=new HashMap<Integer, Double>();

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id=id;
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime=createTime;
    }

    @Override
    public Double getAmount() {
        return amount;
    }

    @Override
    public void setAmount(Double amount) {
        this.amount=amount;
    }

    @Override
    public Map<Integer, Double> getDetail() {
        return detail;
    }

    @Override
    public void setDetail(Map<Integer, Double> detail) {
        this.detail=detail;
    }

    PersonalOrder(){}
}
