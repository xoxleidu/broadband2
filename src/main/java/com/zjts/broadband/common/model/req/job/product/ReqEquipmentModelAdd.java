package com.zjts.broadband.common.model.req.job.product;


import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ReqEquipmentModelAdd implements Serializable {
    private static final long serialVersionUID = 1001943494952931101L;
    private Integer id;
    @ApiModelProperty(name="设备型号状态",example = "WIFF-003")
    @NotNull(message = "型号不能为空")
    private String model;
    @ApiModelProperty(name="设备型号状态",example = "0")
    private String status;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}