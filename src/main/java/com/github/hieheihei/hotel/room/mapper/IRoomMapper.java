package com.github.hieheihei.hotel.room.mapper;

import com.github.hieheihei.hotel.room.model.RoomModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IRoomMapper {
    void insert(RoomModel rm);

    void insertTypes(@Param("id") String id, @Param("types") int[] type_ids);

    void delete(RoomModel rm);

    void update(RoomModel rm);

    RoomModel selectById(int id);

    List<RoomModel> selectByAll();

    List<RoomModel> selectByAllWithType();
}
