package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomTypeModel;

import java.util.List;

public interface IRoomTypeService {

    void add(RoomTypeModel rm);

    void remove(RoomTypeModel rm);

    /**
     * @param rm rm.id != null
     */
    void modify(RoomTypeModel rm);

    List<RoomTypeModel> getByAll();

}
