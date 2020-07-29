package com.github.hieheihei.hotel.admin.mapper;

import com.github.hieheihei.hotel.admin.model.UserModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IUserMapper {
    UserModel selectById(String id);

    void update(UserModel um);
}
