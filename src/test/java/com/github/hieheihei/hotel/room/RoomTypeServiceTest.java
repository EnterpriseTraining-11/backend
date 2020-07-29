package com.github.hieheihei.hotel.room;

import com.github.hieheihei.hotel.room.service.IRoomTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class RoomTypeServiceTest {

    private IRoomTypeService roomTypeService;

    @Autowired
    public RoomTypeServiceTest(IRoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @Test
    public void addTest() {

    }


}
