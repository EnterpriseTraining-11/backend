package com.github.hieheihei.hotel.room.model;

import org.apache.ibatis.type.Alias;

@Alias("RoomType")
public class RoomTypeModel {
    private int id;
    private String name;
    private double price;
    private int max_num;
    private String message;

    public int getId() {
        return id;
    }

    public RoomTypeModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public RoomTypeModel setName(String name) {
        this.name = name;
        return this;
    }

    public double getPrice() {
        return price;
    }

    public RoomTypeModel setPrice(double price) {
        this.price = price;
        return this;
    }

    public int getMax_num() {
        return max_num;
    }

    public RoomTypeModel setMax_num(int max_num) {
        this.max_num = max_num;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public RoomTypeModel setMessage(String message) {
        this.message = message;
        return this;
    }
}
