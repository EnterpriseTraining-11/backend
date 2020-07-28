package com.github.hieheihei.hotel.room.model;

import org.apache.ibatis.type.Alias;

@Alias("RoomType")
public class RoomTypeModel {
//# room_type(id,tp_name,price,max_num,message)

    private int id;
    private String name;
    private double price;
    private int maxNum;
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
