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
    public boolean validate(UserModel am) {
        UserModel find = adminMapper.selectById(am.getId());
        if (find != null && Objects.equals(am.getPassword(), find.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public UserModel getById(String id) {
        return adminMapper.selectById(id);
    }

}
