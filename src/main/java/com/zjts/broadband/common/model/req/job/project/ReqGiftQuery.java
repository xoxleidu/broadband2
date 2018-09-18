package com.zjts.broadband.common.model.req.job.project;

import com.zjts.broadband.common.model.BaseModel;

public class ReqGiftQuery extends BaseModel {
    private Integer gId;

    private String name;

    private Integer stock;

    private String status;

    public Integer getgId() {
        return gId;
    }

    public void setgId(Integer gId) {
        this.gId = gId;
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

}
