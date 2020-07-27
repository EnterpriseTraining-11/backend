package com.github.hieheihei.hotel.admin.mapper;

import com.github.hieheihei.hotel.admin.model.AdminModel;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface IAdminMapper {
    AdminModel selectById(String id);

    void update(AdminModel am);
}
