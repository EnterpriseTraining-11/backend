package com.github.hieheihei.hotel.admin.service.impl;

import com.github.hieheihei.hotel.admin.mapper.IUserMapper;
import com.github.hieheihei.hotel.admin.model.UserModel;
import com.github.hieheihei.hotel.admin.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class UserServiceImpl implements IUserService {

    private final IUserMapper adminMapper;

    @Autowired
    public UserServiceImpl(IUserMapper userMapper) {
        this.adminMapper = userMapper;
    }

    @Override
    public UserModel validate(UserModel um) {
        UserModel find = adminMapper.selectByName(um.getName());
        if (find != null && Objects.equals(um.getPassword(), find.getPassword())) {
            return find;
        } else {
            return null;
        }
    }

    @Override
    public UserModel getById(String id) {
        return adminMapper.selectById(id);
    }

}
