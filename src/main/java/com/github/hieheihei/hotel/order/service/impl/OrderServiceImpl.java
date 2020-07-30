package com.github.hieheihei.hotel.order.service.impl;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.order.mapper.IOrderMapper;
import com.github.hieheihei.hotel.order.model.OrderModel;
import com.github.hieheihei.hotel.order.service.IOrderService;
import com.github.hieheihei.hotel.room.mapper.IRoomMapper;
import com.github.hieheihei.hotel.room.model.RoomModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService {

    private IOrderMapper orderMapper;
    private IRoomMapper roomMapper;

    @Autowired
    public OrderServiceImpl(IOrderMapper orderMapper, IRoomMapper roomMapper) {
        this.orderMapper = orderMapper;
        this.roomMapper = roomMapper;
    }

    @Override
    public void add(OrderModel om) {
        orderMapper.insertToRoomOrder(om);
        List<GuestModel> gs = om.getGuests();
        for (GuestModel gm : gs) {
            orderMapper.insertToGuestRoomOrder(om.getId(), gm.getId());
        }
    }

    @Override
    public void remove(OrderModel om) {
        //次序不可换——外键
        orderMapper.deleteFromGuestRoomOrder(om.getId());
        orderMapper.deleteFromRoomOrder(om.getId());
    }

    @Override
    public void modify(OrderModel om) {
        orderMapper.updateRoomOrder(om);
        List<GuestModel> gs = om.getGuests();
        if (gs != null) {
            orderMapper.deleteFromGuestRoomOrder(om.getId());
            for (GuestModel gm : gs) {
                orderMapper.insertToGuestRoomOrder(om.getId(), gm.getId());
            }
        }
    }

    @Override
    public OrderModel getByRoomIdWithRoomAndGuest(int roomId) {
        return orderMapper.selectByRoomIdWithRoomAndGuest(roomId);
    }

    @Override
    public OrderModel getByIdWithRoomAndGuest(int id) {
        return orderMapper.selectByIdWithRoomAndGuest(id);
    }

    @Override
    public OrderModel getByIdWithRoomAndRoomTypeAndGuest(int id) {
        OrderModel om = orderMapper.selectByIdWithRoomAndGuest(id);
        RoomModel rm = roomMapper.selectByIdWithType(om.getRoom().getId());
        om.setRoom(rm);
        return om;
    }

    @Override
    public List<OrderModel> getByAllWithRoomAndGuest() {
        return orderMapper.selectByAllWithRoomAndGuest();
    }

    @Override
    public List<OrderModel> selectByAllWithRoomAndGuest() {
        return orderMapper.selectByRoomIdWithRoomAndTypeAndGuest();
    }
}
