package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomModel;

import java.util.List;

public interface IRoomService {
    List<RoomModel> getByAllWithType();
    void delete(RoomModel rm);
}
