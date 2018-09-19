package com.zjts.broadband.common.model.req.job.project;

import com.zjts.broadband.common.model.BaseModel;

import javax.validation.constraints.Min;

public class ReqGiftUse extends BaseModel {
    private Integer gId;

    private String name;
    @Min(0)
    private Integer output;


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

    public Integer getOutput() {
        return output;
    }

    public void setOutput(Integer output) {
        this.output = output;
    }

}
