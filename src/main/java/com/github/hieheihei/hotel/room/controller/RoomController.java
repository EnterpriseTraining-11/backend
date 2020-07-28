package com.github.hieheihei.hotel.room.controller;

import com.github.hieheihei.hotel.result.Result;
import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private IRoomService roomService;

    @Autowired
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }

    @PostMapping("/add")
    public Result<RoomModel> add(AddFormData data) {
        roomService.add(data.code, data.type);

        Result<RoomModel> result = new Result<>();
        result.setStatus("OK");
        result.setMessage("成功添加房间：" + data.code);
        return result;
    }

    @RequestMapping("/delete")
    public Result<RoomModel> delete(@RequestParam int id) {
        return null;
    }

    @GetMapping("/list/{page}")
    public Result<RoomModel> getListWithPage(@RequestParam int rows, @PathVariable int page) {

        List<RoomModel> list = roomService.getListWithPage(rows, page);
        Result<RoomModel> result = new Result<>();
        result.setModels(list);
        result.setStatus("OK");
        result.setMessage("成功获取房间列表,行数=" + rows + ",页号=" + page);

        return result;
    }


}

class AddFormData {
    public String code;
    public String type;
}
