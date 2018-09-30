package com.zjts.broadband.common.model.req.job.product;

import com.zjts.broadband.common.model.BaseModel;

public class ReqEquipmentModelQuery extends BaseModel {

    private Integer id;

    private String model;

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