package com.github.hieheihei.hotel.room.controller;

import com.github.hieheihei.hotel.result.Result;
import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import com.github.hieheihei.hotel.room.service.IRoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roomType")
public class RoomTypeController {

    private final IRoomTypeService roomTypeService;

    @Autowired
    public RoomTypeController(IRoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    /**
     * 传入name,price,maxNum,message
     */
    @CrossOrigin
    @PostMapping(value = "/add")
    public Result<RoomTypeModel> add(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        roomTypeService.add(rm);

        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    /**
     * 传入id
     */
    @CrossOrigin
    @RequestMapping(value = "/delete")
    public Result<RoomTypeModel> delete(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        roomTypeService.remove(rm);

        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    /**
     * payload: id,name,price,maxNum,message
     * id必有，其他4项可选，只修改不为null的属性
     *
     * @param rm
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "/update")
    public Result<RoomTypeModel> update(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        roomTypeService.modify(rm);

        result.setStatus("OK");
        result.setMessage("更新成功");
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public Result<RoomTypeModel> getByAll() {
        Result<RoomTypeModel> result = new Result<>();

        result.setModels(roomTypeService.getByAll());

        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
