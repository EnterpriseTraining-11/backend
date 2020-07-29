package com.github.hieheihei.hotel.order.mapper;

import com.github.hieheihei.hotel.order.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface IOrderMapper {

    void insert(OrderModel om);

    void delete(OrderModel om);

    void update(OrderModel om);

    OrderModel selectByIdWithRoomAndGuest(int id);

    List<OrderModel> selectByAllWithRoomAndGuest();

}
