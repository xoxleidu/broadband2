package com.zjts.broadband.common.model.req.job.project;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zjts.broadband.common.model.BaseModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@TableName("t_equipment")
public class ReqEquipmentAdd extends BaseModel {

    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull(message = "型号不能为空")
    private String code;
    @NotNull(message = "价格不能为空")
    @Min(0)
    private BigDecimal price;

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

}
