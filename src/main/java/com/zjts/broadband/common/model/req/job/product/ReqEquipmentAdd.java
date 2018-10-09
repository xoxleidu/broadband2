package com.zjts.broadband.common.model.req.job.product;

import com.baomidou.mybatisplus.annotations.TableName;
import com.zjts.broadband.common.model.BaseModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@TableName("equipment")
public class ReqEquipmentAdd implements Serializable {
    private static final long serialVersionUID = 1001943494952931101L;
    private Integer id;
    @ApiModelProperty(name="设备名称",example = "华为光猫",required = true)
    @NotNull(message = "名称不能为空")
    private String name;
    @ApiModelProperty(name="型号id",example = "1",required = true)
    @NotNull(message = "型号id不能为空")
    private Integer modelId;
    @ApiModelProperty(name="设备ID",example = "001",required = true)
    @NotNull(message = "设备ID不能为空")
    private String equipmentId;

    @ApiModelProperty(name="价格",example = "180",required = true)
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
