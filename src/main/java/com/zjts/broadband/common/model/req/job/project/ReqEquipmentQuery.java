package com.zjts.broadband.common.model.req.job.project;

import com.zjts.broadband.common.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import java.math.BigDecimal;


public class ReqEquipmentQuery extends BaseModel {
    private Integer id;
    @ApiModelProperty(name = "名称", example = "小乌龟")
    private String name;
    @ApiModelProperty(name = "编码", example = "001")
    private String code;
    @ApiModelProperty(name = "价格", example = "0")
    private BigDecimal price;
    @ApiModelProperty(name = "状态", example = "0")
    private String status;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}
