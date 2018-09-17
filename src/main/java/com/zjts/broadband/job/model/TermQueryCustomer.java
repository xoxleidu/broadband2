package com.zjts.broadband.job.model;

import com.zjts.broadband.common.model.BaseModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

public class TermQueryCustomer extends BaseModel {

    @NotNull(message = "客户名不能为空")
    @Length(min = 4, max = 10, message = "客户名格式为4-10位数字或字母")
    private String customerName;

    @NotNull(message = "证件号码不能为空")
    private String idcard;

    @NotNull(message = "联系电话不能为空")
    private String mobile;

    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

}
