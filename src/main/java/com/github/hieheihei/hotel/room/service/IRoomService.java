package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomModel;

import java.util.List;

public interface IRoomService {
    void add(RoomModel rm);

    void delete(RoomModel rm);

    void modify(RoomModel rm);

    List<RoomModel> getByAllWithType();

    RoomModel getByNameWithType(String name);

    List<RoomModel> getByTypeWithType(int typeId);

}
