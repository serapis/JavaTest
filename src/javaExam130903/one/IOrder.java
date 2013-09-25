package javaExam130903.one;

import java.util.Date;
import java.util.Map;

/**
 * 订单的处理接口，一个订单必须有订单产生的时间(createTime),订单金额(amount),订单详细信息组成(Map<Integer,Double>),订单详细信息的每一条是key是水果编码，value是水果重量
 */
public interface IOrder {
    Long getId();

    void setId(Long id);

    Date getCreateTime();

    void setCreateTime(Date createTime);

    Double getAmount();

    void setAmount(Double amount);

    Map<Integer, Double> getDetail();

    void setDetail(Map<Integer, Double> detail);
}
