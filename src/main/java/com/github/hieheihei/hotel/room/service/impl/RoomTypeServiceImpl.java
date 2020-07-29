package com.github.hieheihei.hotel.room.service.impl;

import com.github.hieheihei.hotel.room.mapper.IRoomTypeMapper;
import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import com.github.hieheihei.hotel.room.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomTypeServiceImpl implements IRoomTypeService {

    private final IRoomTypeMapper roomTypeMapper;

    @Autowired
    public RoomTypeServiceImpl(IRoomTypeMapper roomTypeMapper) {
        this.roomTypeMapper = roomTypeMapper;
    }

    @Override
    public void add(RoomTypeModel rm) {
        roomTypeMapper.insert(rm);
    }

    @Override
    public void remove(RoomTypeModel rm) {
        roomTypeMapper.delete(rm);
    }

    @Override
    public void modify(RoomTypeModel rm) {
        roomTypeMapper.update(rm);
    }

    @Override
    public RoomTypeModel getById(int id) {
        return roomTypeMapper.selectById(id);
    }

    @Override
    public RoomTypeModel getByName(String name) {
        return roomTypeMapper.selectByName(name);
    }

    @Override
    public List<RoomTypeModel> getByCondition(String name, double priceAtMost, int maxNumAtLeast) {
        if (name != null) {
            name = "%" + name + "%";
        }
        return roomTypeMapper.selectByCondition(name, priceAtMost, maxNumAtLeast);
    }

    @Override
    public List<RoomTypeModel> getByAll() {
        return roomTypeMapper.selectByAll();
    }
}
