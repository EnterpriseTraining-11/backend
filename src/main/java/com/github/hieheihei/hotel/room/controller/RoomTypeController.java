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

    /**
     * param: name,price,maxNum
     * 都可选，name若非null则使用like进行过滤,其余两个为查找低于给定值的记录并按price,num降序排列
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<RoomTypeModel> getByAll() {
        Result<RoomTypeModel> result = new Result<>();

//        result.setModels(roomTypeService.getByAll());
        //TODO
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

    /**
     * param: id
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/query/id")
    public Result<RoomTypeModel> getById() {
        Result<RoomTypeModel> result = new Result<>();

//        result.setModels(roomTypeService.getByAll());
        //TODO
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
