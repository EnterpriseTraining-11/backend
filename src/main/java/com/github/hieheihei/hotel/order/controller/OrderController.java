package com.github.hieheihei.hotel.order.controller;

import com.github.hieheihei.hotel.order.model.OrderModel;
import com.github.hieheihei.hotel.order.service.IOrderService;
import com.github.hieheihei.hotel.result.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private IOrderService orderService;

    @Autowired
    public OrderController(IOrderService orderService) {
        this.orderService = orderService;
    }

    @CrossOrigin
    @PostMapping("/add")
    public Result<OrderModel> add(@RequestBody OrderModel om) {
        Result<OrderModel> result = new Result<>();
        orderService.add(om);
        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    @CrossOrigin
    @PostMapping("/remove")
    public Result<OrderModel> remove(@RequestBody OrderModel om) {
        Result<OrderModel> result = new Result<>();
        orderService.remove(om);
        result.setStatus("OK");
        result.setMessage("删除成功");
        return result;
    }

    @CrossOrigin
    @PostMapping("/modify")
    public Result<OrderModel> modify(@RequestBody OrderModel om) {
        Result<OrderModel> result = new Result<>();
        orderService.modify(om);
        result.setStatus("OK");
        result.setMessage("添加成功");
        return result;
    }

    @CrossOrigin
    @GetMapping("/query/all")
    public Result<OrderModel> getByAllWithRoomAndGuest() {
        Result<OrderModel> result = new Result<>();
        result.setModels(orderService.getByAllWithRoomAndGuest());
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

    @CrossOrigin
    @GetMapping("/query/id")
    public Result<OrderModel> getByIdWithRoomAndGuest(@RequestParam int id) {
        Result<OrderModel> result = new Result<>();
        result.setModel(orderService.getByIdWithRoomAndGuest(id));
        result.setStatus("OK");
        result.setMessage("获取成功");
        return result;
    }

}
