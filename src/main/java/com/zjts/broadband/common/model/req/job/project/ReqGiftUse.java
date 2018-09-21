package com.zjts.broadband.common.model.req.job.project;

import com.zjts.broadband.common.model.BaseModel;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ReqGiftUse extends BaseModel {
    private Integer id;
    @NotNull
    private String name;
    @NotNull
    @Min(0)
    private Integer outNumber;


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

    public Integer getOutNumber() {
        return outNumber;
    }

    public void setOutNumber(Integer outNumber) {
        this.outNumber = outNumber;
    }
}
