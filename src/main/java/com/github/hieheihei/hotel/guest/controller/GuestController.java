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
     * 检查提交上来的payload里的idCard对应的guest是否已经在数据库中，
     * 如果不在 就插入，
     * 如果在 就根据非null的属性更改相应的guest
     */
    @CrossOrigin
    @PostMapping(value = "/add-or-modify")
    public Result<GuestModel> merge(@RequestBody GuestModel gm) {
        Result<GuestModel> result = new Result<>();

        guestService.merge(gm);

        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    /**
     * @param gm gm.id != null
     */
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
     * 都可选，若非null则进行过滤，其中name使用like过滤
     *
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<GuestModel> getByCondition(
            @RequestParam(required = false) String idCard,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String gender,
            @RequestParam(required = false) String phone
    ) {
        Result<GuestModel> result = new Result<>();

        result.setModels(guestService.getByCondition(idCard, name, gender, phone));

        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

    /**
     * param: id
     */
    @CrossOrigin
    @GetMapping(value = "/query/id")
    public Result<GuestModel> getById(@RequestParam int id) {
        Result<GuestModel> result = new Result<>();

        result.setModel(guestService.getById(id));

        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
