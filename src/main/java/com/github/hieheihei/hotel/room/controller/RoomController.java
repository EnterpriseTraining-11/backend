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
     * @param rm
     * @return
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
     * @param rm
     * @return
     */
    @CrossOrigin
    @PostMapping(value = "/delete")
    public Result<RoomModel> delete(@RequestBody RoomModel rm) {
        Result<RoomModel> result = new Result<>();
        roomService.delete(rm);
        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    /**
     * payload: id, code, type.id
     * id必有，其他2项可选，只修改不为null的属性
     *
     * @param rm
     * @return
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
     * param:
     *
     * @return
     */
    @CrossOrigin
    @GetMapping(value = "/query/all")
    public Result<RoomModel> getByAllWithType() {
        Result<RoomModel> result = new Result<>();
        result.setModels(roomService.getByAllWithType());
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/query/name")
    public Result<RoomModel> getByNameWithType(@RequestParam String name) {
        Result<RoomModel> result = new Result<>();
        result.setModel(roomService.getByNameWithType(name));
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }

    @CrossOrigin
    @GetMapping(value = "/query/type")
    public Result<RoomModel> getByTypeWithType(@RequestParam int typeId) {
        Result<RoomModel> result = new Result<>();
        result.setModels(roomService.getByTypeWithType(typeId));
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }






}
