package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomModel;

import java.util.List;

public interface IRoomService {
    void add(RoomModel rm);

    void delete(RoomModel rm);

    List<RoomModel> getByAllWithType();

}
