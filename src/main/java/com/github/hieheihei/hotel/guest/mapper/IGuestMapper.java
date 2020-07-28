package com.github.hieheihei.hotel.guest.mapper;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGuestMapper {

    void insert(GuestModel gm);

    void delete(GuestModel gm);

    void update(GuestModel gm);

    List<GuestModel> selectByAll();
}
