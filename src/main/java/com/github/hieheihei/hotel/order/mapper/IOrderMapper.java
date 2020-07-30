package com.github.hieheihei.hotel.order.mapper;

import com.github.hieheihei.hotel.order.model.OrderModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface IOrderMapper {
//# room_order(ro_id,room_id,ro_start,ro_end,status)
//# guest_room_order(order_id,guest_id)

    void insertToRoomOrder(OrderModel om);

    void insertToGuestRoomOrder(@Param("orderId") int orderId, @Param("guestId") int guestId);

    void deleteFromRoomOrder(int orderId);

    void deleteFromGuestRoomOrder(int orderId);

    void updateRoomOrder(OrderModel om);

    OrderModel selectByRoomIdWithRoomAndGuest(int roomId);

    OrderModel selectByIdWithRoomAndGuest(int id);

    List<OrderModel> selectByAllWithRoomAndGuest();

}
