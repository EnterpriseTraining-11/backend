package com.github.hieheihei.hotel.guest.mapper;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IGuestMapper {

    void insert(GuestModel gm);

    void delete(GuestModel gm);

    void update(GuestModel gm);

    GuestModel selectById(int id);

    GuestModel selectByIdCard(String idCard);

    List<GuestModel> selectByCondition(String idCard, String name, String gender, String phone);

    List<GuestModel> selectByAll();
}
