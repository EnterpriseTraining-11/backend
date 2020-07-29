package com.github.hieheihei.hotel.room;

import com.github.hieheihei.hotel.room.model.RoomModel;
import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import com.github.hieheihei.hotel.room.service.IRoomService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomServiceTest {

    private IRoomService roomService;

    @Autowired
    public RoomServiceTest(IRoomService roomService) {
        this.roomService = roomService;
    }

    @Test
    void addAndRemoveTest() {
        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        roomService.add(rm1);

        RoomModel rm2 = roomService.getByCodeWithType("Test1");
        assertNotNull(rm2);

        roomService.remove(rm2);
        assertNull(roomService.getByCodeWithType("Test1"));
    }

    @Test
    void updateTest() {
        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        roomService.add(rm1);

        RoomModel rm2 = roomService.getByCodeWithType("Test1");
        rm2.setCode("Test2");
        rm2.setType(null);
        roomService.modify(rm2);
        assertNotNull(roomService.getByCodeWithType("Test2"));
        roomService.remove(roomService.getByCodeWithType("Test2"));
    }

    @Test
    void getByConditionWithTypeTest() {

        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        roomService.add(rm1);
        RoomModel rm2 = new RoomModel();
        rm2.setCode("Test2");
        rm2.setType(new RoomTypeModel() {{
            setId(1);
        }});
        roomService.add(rm2);
        RoomModel rm3 = new RoomModel();
        rm3.setCode("Test3");
        rm3.setType(new RoomTypeModel() {{
            setId(2);
        }});
        roomService.add(rm3);


        List<RoomModel> list1 = roomService.getByConditionWithType("Test1", "普");
        List<RoomModel> list2 = roomService.getByConditionWithType(null, "普");
        List<RoomModel> list3 = roomService.getByConditionWithType(null, null);

        assertTrue(list1.size() == 1);
        assertTrue(list2.size() >= 2);
        assertTrue(list3.size() >= 3);

        roomService.remove(roomService.getByCodeWithType(rm1.getCode()));
        roomService.remove(roomService.getByCodeWithType(rm2.getCode()));
        roomService.remove(roomService.getByCodeWithType(rm3.getCode()));
    }

    @Test
    public void getByIdWithTypeTest() {
        RoomModel rm1 = new RoomModel();
        rm1.setCode("Test1");
        rm1.setType(new RoomTypeModel() {{
            setId(1);
        }});
        roomService.add(rm1);

        RoomModel rm2 = roomService.getByCodeWithType(rm1.getCode());

        RoomModel rm3 = roomService.getByIdWithType(rm2.getId());

        assertEquals(rm2.getCode(), rm3.getCode());
        assertEquals(rm2.getId(), rm3.getId());
        assertEquals(rm2.getType().getId(), rm3.getType().getId());

        roomService.remove(rm3);

    }

}
