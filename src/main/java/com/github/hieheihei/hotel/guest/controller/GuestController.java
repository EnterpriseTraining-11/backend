package com.github.hieheihei.hotel.guest.controller;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.guest.service.IGuestService;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/guest")
public class GuestController {

    private final IGuestService guestService;

    @Autowired
    public GuestController(IGuestService guestService) {
        this.guestService = guestService;
    }

    @CrossOrigin
    @PostMapping(value = "/add")
    public Result<GuestModel> add(@RequestBody GuestModel gm) {
        Result<GuestModel> result = new Result<>();

        guestService.add(gm);

        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "/remove")
    public Result<GuestModel> remove(@RequestBody GuestModel gm) {
        Result<GuestModel> result = new Result<>();

        guestService.remove(gm);

        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    @CrossOrigin
    @PostMapping(value = "/modify")
    public Result<GuestModel> modify(@RequestBody GuestModel gm) {
        Result<GuestModel> result = new Result<>();

        guestService.modify(gm);

        result.setStatus("OK");
        result.setMessage("修改成功");
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/add")
    public Result<GuestModel> getByAll() {
        Result<GuestModel> result = new Result<>();

        result.setModels(guestService.getByAll());

        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
