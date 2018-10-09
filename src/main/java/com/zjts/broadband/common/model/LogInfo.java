package com.zjts.broadband.common.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "LoggerInfo")
@CompoundIndexes(@CompoundIndex(name = "createDate", def = "{ createDate : 1}"))
public class LogInfo {
    private static final long serialVersionUID = 4495390935587105239L;

    @Id
    private Long createDate;
    private String userName;
    private String description;
    private String method;
    private String requestIp;
    private String exceptionCode;
    private String exceptionDetail;
    private String params;


    public LogInfo(){}

    public LogInfo(String userName, String description, String method, String requestIp, String exceptionCode, String exceptionDetail, String params, Long createDate) {
        this.userName = userName;
        this.description = description;
        this.method = method;
        this.requestIp = requestIp;
        this.exceptionCode = exceptionCode;
        this.exceptionDetail = exceptionDetail;
        this.params = params;
        this.createDate = createDate;
    }

    public void setExceptionDetail(String exceptionDetail) {
        this.exceptionDetail = exceptionDetail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestIp() {
        return requestIp;
    }

    public void setRequestIp(String requestIp) {
        this.requestIp = requestIp;
    }

    public String getExceptionCode() {
        return exceptionCode;
    }

    public void setExceptionCode(String exceptionCode) {
        this.exceptionCode = exceptionCode;
    }

    public String getExceptionDetail() {
        return exceptionDetail;
    }



    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Long getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Long createDate) {
        this.createDate = createDate;
    }
    @Override
    public String toString() {
        return "LogInfo{" +
                "userName='" + userName + '\'' +
                ", description='" + description + '\'' +
                ", method='" + method + '\'' +
                ", requestIp='" + requestIp + '\'' +
                ", exceptionCode='" + exceptionCode + '\'' +
                ", exceptionDetail='" + exceptionDetail + '\'' +
                ", params='" + params + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
