package com.zjts.broadband.common.model.req.job.orders;

import javax.validation.constraints.NotNull;

public class ReqUpdateOrderType {
    //订单状态
    @NotNull(message = "订单状态不能为空")
    private Integer type;
    //订单Id
    @NotNull(message = "订单Id不能为空")
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}
