package com.zjts.broadband.common.model.req.job.orders;

import javax.validation.constraints.NotNull;

public class ReqUpdateMoney {
    //用户ID
    @NotNull(message = "用户ID不能为空")
    private Integer customerId;
    //订单ID
    @NotNull(message = "订单ID不能为空")
    private Integer Id;
    //充值金额
    @NotNull(message = "充值金额不能为空")
    private Integer money;
    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }


    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }


}
