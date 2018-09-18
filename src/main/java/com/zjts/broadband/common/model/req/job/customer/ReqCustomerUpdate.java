package com.zjts.broadband.common.model.req.job.customer;

import com.zjts.broadband.common.model.BaseModel;
import com.zjts.broadband.util.pio.convert.ExportConfig;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassNameReqUpdateCustomer
 * @Description TODO
 * @Authoradmin
 * @Description:前端传输客户进行逻辑删除类
 * @Date2018/9/1716:07
 * @Version1.0
 **/

public class ReqCustomerUpdate{

    @ExportConfig(value = "编号")
    private Integer id;

    @NotNull(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名格式为4-10位数字或字母")
    private String customerName;

    @NotNull(message = "联系电话不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8|9)\\d{9}$",message = "手机号码格式错误")
    private String mobile;

    @NotNull(message = "联系人不能为空")
    private String contacts;

    @NotNull(message = "联系电话不能为空")
    private String contactMobile;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts;
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}
