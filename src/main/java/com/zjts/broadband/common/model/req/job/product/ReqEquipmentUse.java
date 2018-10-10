package com.zjts.broadband.common.model.req.job.product;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


public class ReqEquipmentUse implements Serializable {
    private static final long serialVersionUID = 1001943494952931101L;
    @ApiModelProperty(name = "设备名称", example = "1")
    private String name;

    @ApiModelProperty(name = "型号id", example = "1")
    @NotNull
    private Integer modelId;

    @ApiModelProperty(name = "型号")
    private String model;

    @ApiModelProperty(name = "数量")
    @NotNull
    private Integer number;

    @ApiModelProperty(name = "价格")
    private BigDecimal price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
