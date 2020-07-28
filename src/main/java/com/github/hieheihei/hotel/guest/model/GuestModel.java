package com.github.hieheihei.hotel.guest.model;

import org.apache.ibatis.type.Alias;

@Alias("Guest")
public class GuestModel {
    //# guest(id,id_card,gt_name,gender,phone)

    private int id;
    private String idCard;
    private String name;
    private String gender;
    private String phone;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
