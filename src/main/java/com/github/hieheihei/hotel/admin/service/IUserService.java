package com.github.hieheihei.hotel.admin.service;

import com.github.hieheihei.hotel.admin.model.UserModel;

public interface IUserService {

    boolean validate(UserModel am);

    UserModel getById(String id);

}
