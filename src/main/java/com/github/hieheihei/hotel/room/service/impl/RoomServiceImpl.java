package com.github.hieheihei.hotel.room.service.impl;

import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    @Override
    public void add(String code, String type) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public List<RoomModel> getListWithPage(int rows, int page) {
        return null;
    }
}
