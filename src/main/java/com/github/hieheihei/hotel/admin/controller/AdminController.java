package com.github.hieheihei.hotel.admin.controller;

import com.github.hieheihei.hotel.admin.model.UserModel;
import com.github.hieheihei.hotel.admin.service.IUserService;
import com.github.hieheihei.hotel.encrypt.Encrypt;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final IUserService adminService;

    @Autowired
    public AdminController(IUserService adminService) {
        this.adminService = adminService;
    }

    @CrossOrigin
    @PostMapping("/login")
    public Result<UserModel> login(@RequestBody UserModel um) throws Exception {
        Result<UserModel> result = new Result<>();
        UserModel validated = adminService.validate(um);
        if (validated != null) {
            validated.setPassword(Encrypt.getEncrypt().encrypt(validated.getPassword()));
            result.setModel(validated);
            result.setStatus("OK");
            result.setMessage("登录成功");

        } else {
            result.setStatus("Fail");
            result.setMessage("登录失败");
            return result;
        }
        return result;
    }

    @CrossOrigin
    @GetMapping("/validate")
    public Result<UserModel> validate(@RequestBody UserModel um) throws Exception {
        Result<UserModel> result = new Result<>();
        um.setPassword(Encrypt.getEncrypt().decrypt(um.getPassword()));
        UserModel validated = adminService.validate(um);
        if (validated != null) {
            validated.setPassword(Encrypt.getEncrypt().decrypt(um.getPassword()));
            result.setModel(validated);
            result.setStatus("OK");
            result.setMessage("登录成功");

        } else {
            result.setStatus("Fail");
            result.setMessage("登录失败");
            return result;
        }
        return result;
    }


}
