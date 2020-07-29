package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomTypeModel;

import java.util.List;

public interface IRoomTypeService {

    void add(RoomTypeModel rt);

    void remove(RoomTypeModel rt);

    /**
     * @param rt rt.id != null
     */
    void modify(RoomTypeModel rt);

    RoomTypeModel getById(int id);

    RoomTypeModel getByName(String name);

    List<RoomTypeModel> getByCondition(String name, double priceAtMost, int maxNumAtLeast);

    List<RoomTypeModel> getByAll();

}
