package com.github.hieheihei.hotel.order;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.order.model.OrderModel;
import com.github.hieheihei.hotel.order.service.IOrderService;
import com.github.hieheihei.hotel.room.model.RoomModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是半人工测试，只能依序手动运行单个测试
 */
@SpringBootTest
public class OrderServiceTest {

    private IOrderService orderService;

    @Autowired
    public OrderServiceTest(IOrderService orderService) {
        this.orderService = orderService;
    }

    private OrderModel generateOrderModel() {
        RoomModel rm = new RoomModel();
        rm.setId(1);

        GuestModel gm1 = new GuestModel();
        gm1.setId(1);
        GuestModel gm2 = new GuestModel();
        gm2.setId(2);
        List<GuestModel> gs = new ArrayList<>() {{
            add(gm1);
            add(gm2);
        }};

        OrderModel om = new OrderModel();
        om.setRoom(rm);
        om.setGuests(gs);
        om.setStatus("预约");
        om.setStart("2020-10-10 10:10:10");
        om.setEnd("2020-10-11 10:10:10");

        return om;
    }

    @Test
    public void addTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);
    }

    @Test
    public void removeTest() {

    }


}
