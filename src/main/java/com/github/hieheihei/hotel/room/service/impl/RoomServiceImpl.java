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
    public void add(RoomModel rm) {
        roomMapper.insert(rm);
    }

    @Override
    public void delete(RoomModel rm) {
        roomMapper.delete(rm);
    }

    @Override
    public void modify(RoomModel rm) {
        roomMapper.update(rm);
    }

    @Override
    public List<RoomModel> getByAllWithType() {
        return roomMapper.selectByAllWithType();
    }

    @Override
    public RoomModel getByNameWithType(String name) {
        return roomMapper.selectByNameWithType(name);
    }

    @Override
    public List<RoomModel> getByTypeWithType(int typeId) {
        return roomMapper.selectByTypeWithType(typeId);
    }
}
