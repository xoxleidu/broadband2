package com.zjts.broadband.common.model.req.job.orders;

import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

/**
 * @ClassNameReqOrderDetailed
 * @Description TODO
 * @Authoradmin
 * @Date2018/9/2917:12
 * @Version1.0
 **/

public class ReqOrderDetailed {
    @Length(min=20, max=20)
    @NotNull(message = "订单编号不能为空")
    private String orderNumber;//订单编号

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
