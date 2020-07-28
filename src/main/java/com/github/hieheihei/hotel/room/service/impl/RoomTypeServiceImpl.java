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

        RoomTypeModel nRm = roomTypeMapper.selectById(rm.getId());
        if (rm.getName() != null) {
            nRm.setName(rm.getName());
        }
        if (rm.getMaxNum() > 0) {
            nRm.setMaxNum(rm.getMaxNum());
        }
        if (rm.getPrice() > 0) {
            nRm.setPrice(rm.getPrice());
        }
        if (rm.getMessage() != null) {
            nRm.setMessage(rm.getMessage());
        }

        roomTypeMapper.update(nRm);
    }

    @Override
    public List<RoomTypeModel> getByAll() {
        return roomTypeMapper.selectByAll();
    }
}
