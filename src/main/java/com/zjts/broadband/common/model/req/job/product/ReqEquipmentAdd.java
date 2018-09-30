package com.zjts.broadband.common.model.req.job.product;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zjts.broadband.common.model.BaseModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@TableName("equipment")
public class ReqEquipmentAdd extends BaseModel {
    private Integer id;
    @NotNull(message = "名称不能为空")
    private String name;
    @NotNull(message = "型号id不能为空")
    private Integer modelId;
    @NotNull(message = "设备ID不能为空")
    private String equipmentId;
    @NotNull(message = "价格不能为空")
    @Min(0)
    private BigDecimal price;

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

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
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
        this.status = status;
    }
}
