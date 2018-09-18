package com.zjts.broadband.common.model.req.job.project;

import com.zjts.broadband.common.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReqGiftAdd extends BaseModel {
    @NotNull(message = "赠品名不能为空")
    @ApiModelProperty(name = "用户名", example = "zhangsan", required = true)
    private String name;

    @Min(value = 0, message = "入库数量不能为负数")
    @ApiModelProperty(name = "库存数量", example = "80", required = true)
    private Integer stock;

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


}
