package com.zjts.broadband.job.model;

import com.zjts.broadband.util.pio.convert.ExportConfig;

public class EquipmentModel {
    @ExportConfig(value = "编号")
    private Integer id;
    @ExportConfig(value = "型号")
    private String model;
    @ExportConfig(value = "状态")
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