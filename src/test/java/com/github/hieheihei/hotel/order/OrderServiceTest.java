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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class OrderServiceTest {

    private IOrderService orderService;

    @Autowired
    public OrderServiceTest(IOrderService orderService) {
        this.orderService = orderService;
    }

    private OrderModel generateOrderModel() {
        RoomModel rm = new RoomModel();
        rm.setId(2);

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
    public void addAndRemoveTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);
        assertNotNull(orderService.getByIdWithRoomAndGuest(om1.getId()));

        orderService.remove(om1);
        assertNull(orderService.getByIdWithRoomAndGuest(om1.getId()));
    }

    @Test
    void modifyTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);

        om1.setStatus("入住");

        GuestModel gm1 = new GuestModel();
        gm1.setId(1);
        GuestModel gm2 = new GuestModel();
        gm2.setId(4);
        List<GuestModel> gs = new ArrayList<>() {{
            add(gm1);
            add(gm2);
        }};
        om1.setGuests(gs);

        orderService.modify(om1);

        OrderModel om2 = orderService.getByIdWithRoomAndGuest(om1.getId());
        assertEquals(om1.getRoom().getId(), om2.getRoom().getId());
        assertEquals(om1.getGuests().size(), om2.getGuests().size());
        assertEquals(om1.getStart(), om2.getStart());
        assertEquals(om1.getStatus(), om2.getStatus());

        orderService.remove(om1);
    }

    @Test
    public void getByIdWithRoomAndGuestTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);

        OrderModel om2 = orderService.getByIdWithRoomAndGuest(om1.getId());

        assertEquals(om1.getRoom().getId(), om2.getRoom().getId());
        assertEquals(om1.getGuests().size(), om2.getGuests().size());
        assertEquals(om1.getStart(), om2.getStart());

        orderService.remove(om2);
    }

    @Test
    public void getByAllWithRoomAndGuestTest() {

        int count = orderService.getByAllWithRoomAndGuest().size();

        OrderModel om1 = generateOrderModel();
        orderService.add(om1);

        int nCount = orderService.getByAllWithRoomAndGuest().size();
        assertTrue(nCount == count + 1);

        orderService.remove(om1);
    }

    @Test
    public void getByRoomIdWithRoomAndGuestTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);

        OrderModel om2 = orderService.getByRoomIdWithRoomAndGuest(om1.getRoom().getId());

        assertEquals(om1.getRoom().getId(), om2.getRoom().getId());
        assertEquals(om1.getGuests().size(), om2.getGuests().size());
        assertEquals(om1.getStart(), om2.getStart());

        orderService.remove(om2);
    }

    @Test
    public void getByIdWithRoomAndRoomTypeAndGuestTest() {
        OrderModel om1 = generateOrderModel();
        orderService.add(om1);

        OrderModel om2 = orderService.getByIdWithRoomAndRoomTypeAndGuest(om1.getId());

        assertEquals(om1.getRoom().getId(), om2.getRoom().getId());
        assertEquals(om1.getGuests().size(), om2.getGuests().size());
        assertEquals(om1.getStart(), om2.getStart());
        assertNotNull(om2.getRoom().getType());

        orderService.remove(om2);
    }


}
