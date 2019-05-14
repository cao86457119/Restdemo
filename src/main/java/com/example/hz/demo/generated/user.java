package com.example.hz.demo.generated;

import java.io.Serializable;

public class user implements Serializable {
    private Integer id;

    private String name;

    private Integer companyId;

    private String mycatOpTime;

    private static final long serialVersionUID = 1L;

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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getMycatOpTime() {
        return mycatOpTime;
    }

    public void setMycatOpTime(String mycatOpTime) {
        this.mycatOpTime = mycatOpTime == null ? null : mycatOpTime.trim();
    }
}