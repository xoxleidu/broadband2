package com.zjts.broadband.common.model.req.job.orders;

import com.zjts.broadband.job.model.OrderInsert;

import java.util.List;

public class ReqOrderAdd {
    //订单ID
    private Integer orderId;
    //资费表ID
    private Integer expensesId;
    //设备表ID
   private List<ReqOrderAdd> equipmentId;
    //套餐表ID
    private Integer productId;



    //赠品表ID
    private List<ReqOrderAdd> giftId;

    public List<ReqOrderAdd> getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(List<ReqOrderAdd> equipmentId) {
        this.equipmentId = equipmentId;
    }

    public List<ReqOrderAdd> getGiftId() {
        return giftId;
    }

    public void setGiftId(List<ReqOrderAdd> giftId) {
        this.giftId = giftId;
    }

    //订单金额
    private Integer discount;
    //用户ID
    private Integer customerId;
    //订单状态
    private Integer type;
    //安装时间
    private Integer installDate;
    // 安装地址
    private String installAddress;
    //余额
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getExpensesId() {
        return expensesId;
    }

    public void setExpensesId(Integer expensesId) {
        this.expensesId = expensesId;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }


    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getInstallDate() {
        return installDate;
    }

    public void setInstallDate(Integer installDate) {
        this.installDate = installDate;
    }

    public String getInstallAddress() {
        return installAddress;
    }

    public void setInstallAddress(String installAddress) {
        this.installAddress = installAddress;
    }
}
