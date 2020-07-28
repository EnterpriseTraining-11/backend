package com.github.hieheihei.hotel.room.service.impl;

import com.github.hieheihei.hotel.room.mapper.IRoomMapper;
import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements IRoomService {
    private final IRoomMapper roomMapper;

    @Autowired
    public RoomServiceImpl(IRoomMapper roomMapper) {
        this.roomMapper = roomMapper;
    }
    @Override
    public List<RoomModel> getByAllWithType() {
        return roomMapper.selectByAllWithType();
    }

    @Override
    public void add(RoomModel rm) {
        roomMapper.insert(rm);
    }

    @Override
    public void delete(RoomModel rm) {
        roomMapper.delete(rm);
    }
}
