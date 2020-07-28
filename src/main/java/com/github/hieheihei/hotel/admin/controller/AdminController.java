package com.github.hieheihei.hotel.admin.controller;

import com.github.hieheihei.hotel.admin.model.UserModel;
import com.github.hieheihei.hotel.admin.service.IUserService;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IUserService adminService;

    @Autowired
    public AdminController(IUserService adminService) {
        this.adminService = adminService;
    }

    @PostMapping
    public Result<UserModel> login(UserModel um) {
        if (adminService.validate(um)) {
            um = adminService.getById(um.getId());
            //TODO
            Result<UserModel> result = new Result<>();
            result.setStatus("OK");
            result.setMessage("登录成功");
            return result;
        } else {
            Result<UserModel> result = new Result<>();
            result.setStatus("OK");
            result.setMessage("登录失败");
            return result;
        }
    }


}
