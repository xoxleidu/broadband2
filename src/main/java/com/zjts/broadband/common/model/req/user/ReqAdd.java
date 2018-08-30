package com.zjts.broadband.common.model.req.user;


import com.zjts.broadband.common.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ReqAdd extends BaseModel {
    @NotNull(message = "用户名不能为空")
    @Length(min = 4, max = 10, message = "用户名格式为4-10位数字或字母")
    @ApiModelProperty(name = "用户名",example = "zhangsan",required = true)
    private String usename;

    @NotNull(message = "密码不能为空")
    @ApiModelProperty(name = "密码",example = "23333",required = true)
    private String password;

    @NotNull(message = "联系电话不能为空")
    @Pattern(regexp = "^1(3|4|5|7|8|9)\\d{9}$",message = "手机号码格式错误")
    @ApiModelProperty(name = "联系方式",example = "13112341234",required = true)
    private String phone;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    public String getUsename() {
        return usename;
    }

    public void setUsename(String usename) {
        this.usename = usename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}