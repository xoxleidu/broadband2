package com.zjts.broadband.job.model;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.zjts.broadband.util.pio.convert.ExportConfig;

import java.math.BigDecimal;
@TableName("equipment")
public class Equipment {
    @TableId
    @ExportConfig(value = "设备id")  //导出Excel时，指定列名
    private Integer equId;
    @ExportConfig(value = "名称")
    private String name;
    @ExportConfig(value = "编码")
    private String code;
    @ExportConfig(value = "价格")
    private BigDecimal price;
    @ExportConfig(value = "入库时间")
    private Integer addTime;
    @ExportConfig(value = "出库时间")
    private Integer outTime;
    @ExportConfig(value = "状态")
    private String status;

    public Integer getEquId() {
        return equId;
    }

    public void setEquId(Integer equId) {
        this.equId = equId;
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

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getOutTime() {
        return outTime;
    }

    public void setOutTime(Integer outTime) {
        this.outTime = outTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }
}