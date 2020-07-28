package com.github.hieheihei.hotel.room.model;

import org.apache.ibatis.type.Alias;

@Alias("Room")
public class RoomModel {
    private int id;
    private String code;
    private RoomTypeModel type;

    public int getId() {
        return id;
    }

    public RoomModel setId(int id) {
        this.id = id;
        return this;
    }

    public String getCode() {
        return code;
    }

    public RoomModel setCode(String code) {
        this.code = code;
        return this;
    }

    public RoomTypeModel getType() {
        return type;
    }

    public RoomModel setType(RoomTypeModel type) {
        this.type = type;
        return this;
    }
}
