package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomModel;

import java.util.List;

public interface IRoomService {
    void add(RoomModel rm);

    void remove(RoomModel rm);

    void modify(RoomModel rm);

    List<RoomModel> getByAllWithType();

    RoomModel getByIdWithType(int id);

    RoomModel getByCodeWithType(String code);

    List<RoomModel> getByTypeWithType(int typeId);

    List<RoomModel> getByConditionWithType(String code, String typeName);

}
