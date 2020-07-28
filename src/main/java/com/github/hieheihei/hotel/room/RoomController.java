package com.github.hieheihei.hotel.room;

import com.github.hieheihei.hotel.result.Result;
import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;

    @Autowired
    public RoomController(IRoomService roomService){this.roomService=roomService;}

    @CrossOrigin
    @RequestMapping(value = "/all-with-type")
    public Result<RoomModel> getByAllWithType(){
        Result<RoomModel> result = new Result<>();
        result.setModels(roomService.getByAllWithType());
        result.setStatus("OK");
        result.setMessage("查询成功");
        return result;
    }
}
