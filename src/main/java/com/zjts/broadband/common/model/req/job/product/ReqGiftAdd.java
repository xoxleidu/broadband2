package com.zjts.broadband.common.model.req.job.product;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ReqGiftAdd implements Serializable {
    private static final long serialVersionUID =1001943494952931101L;
    private Integer id;
    @NotNull(message = "赠品名不能为空")
    @ApiModelProperty(name = "赠品名", example = "洗衣液", required = true)
    private String name;

    @Min(value = 0, message = "入库数量不能为负数")
    @ApiModelProperty(name = "库存数量", example = "80", required = true)
    private Integer stock;

    private Integer amount;
    private Integer output;
    private String status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
