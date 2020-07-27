package com.github.hieheihei.hotel.admin.controller;

import com.github.hieheihei.hotel.admin.model.AdminModel;
import com.github.hieheihei.hotel.admin.service.IAdminService;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IAdminService adminService;

    @Autowired
    public AdminController(IAdminService adminService) {
        this.adminService = adminService;
    }

    @RequestMapping
    public Result<AdminModel> login(AdminModel am) {
        if (adminService.validate(am)) {
            am = adminService.getById(am.getId());
            //TODO
            Result<AdminModel> result = new Result<>();
            result.setStatus("OK");
            result.setMessage("登录成功");
            return result;
        } else {
            Result<AdminModel> result = new Result<>();
            result.setStatus("OK");
            result.setMessage("登录失败");
            return result;
        }
    }


}
