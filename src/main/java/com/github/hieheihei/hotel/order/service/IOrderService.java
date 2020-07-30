package com.github.hieheihei.hotel.order.service;

import com.github.hieheihei.hotel.order.model.OrderModel;

import java.util.List;

public interface IOrderService {

    void add(OrderModel om);

    void remove(OrderModel om);

    void modify(OrderModel om);

    OrderModel getByRoomIdWithRoomAndGuest(int roomId);

    OrderModel getByIdWithRoomAndGuest(int id);

    OrderModel getByIdWithRoomAndRoomTypeAndGuest(int id);

    List<OrderModel> getByAllWithRoomAndGuest();

}
