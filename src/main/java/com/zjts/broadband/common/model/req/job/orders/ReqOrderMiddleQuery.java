package com.zjts.broadband.common.model.req.job.orders;

import com.zjts.broadband.common.model.BaseModel;

public class ReqOrderMiddleQuery extends BaseModel {
    private Integer id;

    private Integer orderId;
    //资费表ID
    private Integer expensesid;
    //资费类型
    private String expensesname;
    //资费类型 ID
    private String expensestype;

    private Integer setMealId;

    private Integer equipmentId;

    private Integer productId;

    private Integer discount;

    private Integer orderNumber;

    private Integer createTime;

    private Integer expiryTime;

    private Integer money;

    private String remarks;

    private Integer type;

    private Integer installDate;

    private String installAddress;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Integer getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Integer createTime) {
        this.createTime = createTime;
    }

    public Integer getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(Integer expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
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

    public String getExpensesname() {
        return expensesname;
    }

    public void setExpensesname(String expensesname) {
        this.expensesname = expensesname;
    }

    public String getExpensestype() {
        return expensestype;
    }

    public void setExpensestype(String expensestype) {
        this.expensestype = expensestype;
    }

    public Integer getExpensesid() {

        return expensesid;
    }

    public void setExpensesid(Integer expensesid) {
        this.expensesid = expensesid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getSetMealId() {
        return setMealId;
    }

    public void setSetMealId(Integer setMealId) {
        this.setMealId = setMealId;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
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

    private Integer customerId;
}
