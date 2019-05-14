package com.example.hz.demo.entity;

import java.util.Date;

public class PersonEntity {
    public Date getBrithday() {
        return brithday;
    }

    public void setBrithday(Date brithday) {
        this.brithday = brithday;
    }

    public String getAddress() {

        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSchool() {
        return school;

    }

    public void setSchool(String school) {
        this.school = school;
    }

    private String name;
    private String school;
    private String address;
    private Date brithday;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private int id;

}
