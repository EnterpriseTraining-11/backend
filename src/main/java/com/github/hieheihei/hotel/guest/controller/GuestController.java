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

    /**
     * payload: GuestModel
     * 首先检查提交上来的payload里的idCard对应的guest已经在数据库中，如果不在就插入，否则就根据非null的属性更改相应的guest
     * @param gm
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "/add-or-modify")
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

    /**
     * param: idCard, name, gender, phone
     * 都可选，若非null则使用like进行过滤
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<GuestModel> getByAll() {
        Result<GuestModel> result = new Result<>();

        result.setModels(guestService.getByAll());

        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
