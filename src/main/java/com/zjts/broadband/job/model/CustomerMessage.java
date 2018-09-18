package com.zjts.broadband.job.model;

import com.zjts.broadband.util.pio.convert.ExportConfig;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

public class CustomerMessage implements Serializable {
    //定义的私有属性
    @ExportConfig(value = "编号")
    private Integer id;

    @ExportConfig(value = "客户姓名")
    private String customerName;

    @ExportConfig(value = "客户性别")
    private Integer sex;

    @ExportConfig(value = "证件号码")
    private String idcard;

    @ExportConfig(value = "家庭电话")
    private String tel;

    @ExportConfig(value = "手机号码")
    private String mobile;

    @ExportConfig(value = "证件地址")
    private String address;

    @ExportConfig(value = "联系人")
    private String contacts;

    @ExportConfig(value = "联系人电话")
    private String contactMobile;

    @ExportConfig(value = "客户类型")
    private Integer type;

    @ExportConfig(value = "创建时间")
    private Integer creationTime;

    @ExportConfig(value = "状态")
    private Integer status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

}