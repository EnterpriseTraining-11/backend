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
    @RequestMapping(value = "/remove")
    public Result<RoomTypeModel> remove(@RequestBody RoomTypeModel rm) {
        Result<RoomTypeModel> result = new Result<>();

        roomTypeService.remove(rm);

        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    /**
     * payload: id,name,price,maxNum,message
     * id必有，其他4项可选，只修改不为null的属性
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

    /**
     * param: name,price,maxNum
     * 都可选，
     * if name != null 则 匹配 like %name% 的记录
     * if priceAtMost > 0 则  匹配 price <= priceAtMost 的记录
     * if maxNumAtLeast >0 则 匹配 maxNum >= maxNumAtLeast 的记录
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<RoomTypeModel> getByCondition(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) double priceAtMost,
            @RequestParam(required = false) int maxNumAtLeast
    ) {
        Result<RoomTypeModel> result = new Result<>();

        result.setModels(roomTypeService.getByCondition(name, priceAtMost, maxNumAtLeast));
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

    /**
     * param: id
     */
    @CrossOrigin
    @GetMapping(value = "/query/id")
    public Result<RoomTypeModel> getById(@RequestParam int id) {
        Result<RoomTypeModel> result = new Result<>();

        result.setModel(roomTypeService.getById(id));
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
