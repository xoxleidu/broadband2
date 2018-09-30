package com.zjts.broadband.common.model.req.job.product;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class ReqEquipmentModelAdd implements Serializable {
    private static final long serialVersionUID = 1001943494952931101L;
    private Integer id;
    @NotNull
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