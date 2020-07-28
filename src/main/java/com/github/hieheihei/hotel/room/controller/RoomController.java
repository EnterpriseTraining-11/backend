package com.github.hieheihei.hotel.room.controller;

import com.github.hieheihei.hotel.result.Result;
import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;

    @Autowired
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @CrossOrigin
    @GetMapping(value = "/all-with-type")
    public Result<RoomModel> getByAllWithType() {
        Result<RoomModel> result = new Result<>();
        result.setModels(roomService.getByAllWithType());
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/delete")
    public Result<RoomModel> delete(@RequestBody Map<String, Object> payLoad) {
        Result<RoomModel> result = new Result<>();
//        roomService.delete(new RoomModel().setId((Integer) payLoad.get("id")));
        result.setStatus("OK");
        result.setMessage("删除成功--服务层未完成");
        return result;
    }

    @CrossOrigin
    @RequestMapping(value = "/add")
    public Result<RoomModel> add(@RequestBody RoomModel rm) {
        Result<RoomModel> result = new Result<>();
        roomService.add(rm);
        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }
}
