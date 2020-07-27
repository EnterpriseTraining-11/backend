package com.github.hieheihei.hotel.admin.service;

import com.github.hieheihei.hotel.admin.model.AdminModel;

public interface IAdminService {

    boolean validate(AdminModel am);

    AdminModel getById(String id);

}
