package com.github.hieheihei.hotel.order;
import com.github.hieheihei.hotel.order.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class OrderServiceTest {

    private IOrderService orderService;

    @Autowired
    public OrderServiceTest(IOrderService orderService){
        this.orderService = orderService;
    }

    @Test
    public void addTest(){

    }




}
