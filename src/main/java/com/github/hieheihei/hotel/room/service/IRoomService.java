package com.github.hieheihei.hotel.room.service;

import com.github.hieheihei.hotel.room.model.RoomModel;

import java.util.List;

public interface IRoomService {


    void add(String code, String type);

    void remove(int id);

    List<RoomModel> getListWithPage(int rows, int page);


}
