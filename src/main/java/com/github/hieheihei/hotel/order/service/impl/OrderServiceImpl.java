package com.github.hieheihei.hotel.order.service.impl;

import com.github.hieheihei.hotel.order.mapper.IOrderMapper;
import com.github.hieheihei.hotel.order.model.OrderModel;
import com.github.hieheihei.hotel.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderMapper orderMapper;

    @Autowired
    public OrderServiceImpl(IOrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void add(OrderModel om) {
        orderMapper.insert(om);
    }

    @Override
    public void remove(OrderModel om) {
        orderMapper.delete(om);
    }

    @Override
    public void modify(OrderModel om) {
        orderMapper.modify(om);
    }

    @Override
    public OrderModel getByIdWithRoomAndGuest(int id) {
        return orderMapper.selectByIdWithRoomAndGuest(id);
    }

    @Override
    public List<OrderModel> getByAllWithRoomAndGuest() {
        return orderMapper.selectByAllWithRoomAndGuest();
    }
}
