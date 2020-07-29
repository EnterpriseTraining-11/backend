package com.github.hieheihei.hotel.room;

import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
public class RoomServiceTest {

    private IRoomService iRoomService;

    @Autowired
    public RoomServiceTest(IRoomService iRoomService) {
        this.iRoomService = iRoomService;
    }

    @Test
    void addAndRemoveTest() {
        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        iRoomService.add(rm1);

        RoomModel rm2 = iRoomService.getByNameWithType("Test1");
        assertNotNull(rm2);

        iRoomService.remove(rm2);
        assertNull(iRoomService.getByNameWithType("Test1"));
    }

    @Test
    void updateTest() {
        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        iRoomService.add(rm1);

        RoomModel rm2 = iRoomService.getByNameWithType("Test1");
        rm2.setCode("Test2");
        rm2.setType(null);
        iRoomService.modify(rm2);
        assertNotNull(iRoomService.getByNameWithType("Test2"));
        iRoomService.remove(iRoomService.getByNameWithType("Test2"));
    }

}
