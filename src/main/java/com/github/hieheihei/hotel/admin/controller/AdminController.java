package com.github.hieheihei.hotel.admin.controller;

import com.github.hieheihei.hotel.admin.model.UserModel;
import com.github.hieheihei.hotel.admin.service.IUserService;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IUserService adminService;

    @Autowired
    public AdminController(IUserService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login")
    public Result<UserModel> login(@RequestBody UserModel um, HttpSession session) {
        if (adminService.validate(um)) {
            um = adminService.getById(um.getId());

            session.setAttribute("user", um);

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

    @GetMapping("/logout")
    public Result<UserModel> logout(HttpSession session) {
        Result<UserModel> result = new Result<>();

        session.removeAttribute("user");

        result.setStatus("OK");
        result.setMessage("登出成功");
        return result;
    }


}
