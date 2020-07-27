package com.github.hieheihei.hotel.admin.service.impl;

import com.github.hieheihei.hotel.admin.mapper.IAdminMapper;
import com.github.hieheihei.hotel.admin.model.AdminModel;
import com.github.hieheihei.hotel.admin.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class AdminServiceImpl implements IAdminService {

    private final IAdminMapper adminMapper;

    @Autowired
    public AdminServiceImpl(IAdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    @Override
    public boolean validate(AdminModel am) {
        AdminModel find = adminMapper.selectById(am.getId());
        if (find != null && Objects.equals(am.getPassword(), find.getPassword())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public AdminModel getById(String id) {
        return adminMapper.selectById(id);
    }

}
