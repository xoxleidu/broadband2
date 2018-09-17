package com.zjts.broadband.job.model;

import com.zjts.broadband.common.model.BaseModel;

import javax.validation.constraints.NotNull;

public class QueryAllCustomer  extends BaseModel{
    //定义的私有属性
    @NotNull(message = "状态不能为空,默认为0")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
