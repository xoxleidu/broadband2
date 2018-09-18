package com.zjts.broadband.common.model.req.job.customer;

import com.zjts.broadband.common.model.BaseModel;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * @ClassNameReqAddCustomer
 * @Description TODO
 * @Authoradmin
 * @Description:前端传输进行添加客户类
 * @Date2018/9/1716:01
 * @Version1.0
 **/

public class ReqCustomerAdd extends BaseModel {


    @NotNull(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名格式为4-10位数字或字母")
    private String customerName;

    @NotNull(message = "性别不能为空")
    private Integer sex;

    @NotNull(message = "证件号码不能为空")
    private String idcard;

    private String tel;

    @NotNull(message = "联系电话不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8|9)\\d{9}$",message = "手机号码格式错误")
    private String mobile;

    @NotNull(message = "证件地址不能为空")
    private String address;

    @NotNull(message = "联系人不能为空")
    private String contacts;

    @NotNull(message = "联系电话不能为空")
    private String contactMobile;

    @NotNull(message = "客户类型不能为空")
    private Integer type;

    @NotNull(message = "创建时间不能为空")
    private Integer creationTime;

    @NotNull(message = "状态不能为空")
    private Integer status;

    public String getName() {
        return customerName;
    }

    public void setName(String name) {
        this.customerName = name == null ? null : name.trim();
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard == null ? null : idcard.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getContactMobile() {
        return contactMobile;
    }

    public void setContactMobile(String contactMobile) {
        this.contactMobile = contactMobile == null ? null : contactMobile.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Integer creationTime) {
        this.creationTime = creationTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
