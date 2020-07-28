package com.github.hieheihei.hotel.room.mapper;

import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IRoomTypeMapper {

    void insert(RoomTypeModel rm);

    void delete(RoomTypeModel rm);

    void update(RoomTypeModel rm);

    RoomTypeModel selectById(int id);

    List<RoomTypeModel> selectByAll();
}
