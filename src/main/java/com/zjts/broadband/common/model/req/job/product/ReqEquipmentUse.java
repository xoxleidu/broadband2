package com.zjts.broadband.common.model.req.job.product;

import com.zjts.broadband.common.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;


public class ReqEquipmentUse implements Serializable {
    private static final long serialVersionUID = 1001943494952931101L;

    private String name;
    @ApiModelProperty(name = "类型", example = "AN5006-01")
    @NotNull
    private Integer modelId;

    private String model;
    @NotNull
    private Integer number;

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
