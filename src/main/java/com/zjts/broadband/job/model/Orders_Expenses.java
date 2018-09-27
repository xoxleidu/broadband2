package com.zjts.broadband.job.model;

public class Orders_Expenses {
    //订单ID
    private Integer id;
    //资费表ID
    private Integer expensesid;
    //资费类型
    private String expensesname;
    //资费类型 ID
    private String expensestype;
    //套餐表ID
    private Integer setMealId;
    //订单状态
    private Integer type;
    //安装时间
    private Integer installDate;
    // 安装地址
    private String installAddress;
    //设备表ID
    private Integer equipmentId;
    //赠品表ID
    private Integer productId;
    //订单金额
    private Integer discount;
    //用户ID
    private Integer customerId;
    //订单号
    private Integer orderNumber;
    //订单创建时间
    private Integer createTime;
    //订单到期时间
    private Integer expiryTime;
    //余额
    private Integer money;
    //备注
    private String remarks;
    //折扣后的金额
    private  int discountmoney;

    public int getDiscountmoney() {
        return discountmoney;
    }

    public void setDiscountmoney(int discountmoney) {
        this.discountmoney = discountmoney;
    }

    public Integer getExpensesid() {
        return expensesid;
    }

    public void setExpensesid(Integer expensesid) {
        this.expensesid = expensesid;
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
