package com.github.hieheihei.hotel.room.model;

public class RoomModel {

    private int id;
    private String code;
    private RoomTypeModel type;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public RoomTypeModel getType() {
        return type;
    }

    public void setType(RoomTypeModel type) {
        this.type = type;
    }
}
