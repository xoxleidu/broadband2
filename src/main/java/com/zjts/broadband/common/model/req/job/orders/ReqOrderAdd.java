package com.zjts.broadband.common.model.req.job.orders;

import com.zjts.broadband.job.model.OrderInsert;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Map;

public class ReqOrderAdd {


    //产品的Map集合 key 产品类型  value 是产品id
    private Map product;

    //订单金额

    @NotNull(message = "订单金额不能为空")
    @Min(value=0,message = "最小不能小于0")
    @Max(value=1,message = "最大不能大于1")
    private Integer discountMoney;
    //用户ID
    @NotNull(message = "用户ID不能为空")
    private Integer customerId;
    //产品类型
 //   private Integer productType;
    //安装时间
    @NotNull(message = "安装时间不能为空")
    private Integer installDate;
    // 安装地址
    @NotNull(message = "安装地址不能为空")
    @Length(min = 1, max = 50, message = "安装地址长度不能超过50位")
    private String installAddress;
    //余额
    @NotNull(message = "余额不能为空")
    private int money;

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

//    public Integer getProductId() {
//        return productId;
//    }
//
//    public void setProductId(Integer productId) {
//        this.productId = productId;
//    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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

    public Integer getDiscountMoney() {
        return discountMoney;
    }

    public void setDiscountMoney(Integer discountMoney) {
        this.discountMoney = discountMoney;
    }
    public Map getProduct() {
        return product;
    }

    public void setProduct(Map product) {
        this.product = product;
    }
}
