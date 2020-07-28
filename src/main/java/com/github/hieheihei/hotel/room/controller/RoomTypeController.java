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

    @CrossOrigin
    @PostMapping(value = "/add")
    /**
     * 传入name,price,maxNum,message
     */
    public Result<RoomTypeModel> add(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        //todo

        result.setStatus("OK");
        result.setMessage("添加成功-服务层未完成");
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete")
    /**
     * 传入id
     */
    public Result<RoomTypeModel> delete(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        //todo

        result.setStatus("OK");
        result.setMessage("删除成功-服务层未完成");
        return result;
    }

    /**
     * payload: id,name,price,maxNum,message
     * id必有，其他三项可选，只修改不为null的属性
     * @param rm
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "/update")
    public Result<RoomTypeModel> update(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        //todo

        result.setStatus("OK");
        result.setMessage("更新成功-服务层未完成");
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/all")
    public Result<RoomTypeModel> getByAll() {
        Result<RoomTypeModel> result = new Result<>();

        //todo

        result.setStatus("OK");
        result.setMessage("获取成功-服务层未完成");
        return result;
    }

}
