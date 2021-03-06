package com.github.hieheihei.hotel.room.controller;

import com.github.hieheihei.hotel.result.Result;
import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;

    @Autowired
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    /**
     * payload: code, name, type.id
     *
     */
    @CrossOrigin
    @PostMapping(value = "/add")
    public Result<RoomModel> add(@RequestBody RoomModel rm) {
        Result<RoomModel> result = new Result<>();
        roomService.add(rm);
        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    /**
     * payload: id
     *
     */
    @CrossOrigin
    @PostMapping(value = "/remove")
    public Result<RoomModel> remove(@RequestBody RoomModel rm) {
        Result<RoomModel> result = new Result<>();
        roomService.remove(rm);
        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    /**
     * payload: id, code, type.id
     * id必有，其他2项可选，只修改不为null的属性
     *
     */
    @CrossOrigin
    @PostMapping(value = "/modify")
    public Result<RoomModel> modify(@RequestBody RoomModel rm) {
        Result<RoomModel> result = new Result<>();
        roomService.modify(rm);
        result.setStatus("OK");
        result.setMessage("修改成功");
        return result;
    }

    /**
     * param: code, typeName
     * code与typeName都可选，若非null则使用like进行过滤
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<RoomModel> getByConditionWithType(
            @RequestParam(required = false) String code,
            @RequestParam(required = false) String typeName) {
        Result<RoomModel> result = new Result<>();

        result.setModels(roomService.getByConditionWithType(code, typeName));

        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }

    /**
     * param: id
     */
    @CrossOrigin
    @GetMapping(value = "/query/id")
    public Result<RoomModel> getByIdWithType(@RequestParam int id) {
        Result<RoomModel> result = new Result<>();
        result.setModel(roomService.getByIdWithType(id));
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }

}
