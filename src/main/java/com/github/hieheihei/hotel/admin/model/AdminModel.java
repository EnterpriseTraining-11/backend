package com.github.hieheihei.hotel.admin.model;

import org.apache.ibatis.type.Alias;

@Alias("Admin")
public class AdminModel {

    private String id;
    private String password;
    private String name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
