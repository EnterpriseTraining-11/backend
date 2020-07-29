package com.github.hieheihei.hotel.room;

import com.github.hieheihei.hotel.room.model.RoomTypeModel;
import com.github.hieheihei.hotel.room.service.IRoomTypeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class RoomTypeServiceTest {

    private IRoomTypeService roomTypeService;

    @Autowired
    public RoomTypeServiceTest(IRoomTypeService roomTypeService) {
        this.roomTypeService = roomTypeService;
    }

    @Test
    public void addAndRemoveTest() {
        RoomTypeModel rt1 = new RoomTypeModel();
        rt1.setName("TestRT1");
        rt1.setPrice(400);
        rt1.setMaxNum(4);
        roomTypeService.add(rt1);

        RoomTypeModel rt2 = roomTypeService.getByName("TestRT1");
        assertNotNull(rt2);

        roomTypeService.remove(rt2);
        assertNull(roomTypeService.getByName("TestRT1"));
    }

    @Test
    public void modifyTest() {
        RoomTypeModel rt1 = new RoomTypeModel();
        rt1.setName("TestRT1");
        rt1.setPrice(400);
        rt1.setMaxNum(4);
        roomTypeService.add(rt1);

        RoomTypeModel rt2 = roomTypeService.getByName("TestRT1");
        rt2.setName("TestRT2");
        rt2.setMaxNum(3);
        roomTypeService.modify(rt2);

        RoomTypeModel rt3 = roomTypeService.getByName("TestRT2");
        assertEquals(rt3.getId(), rt2.getId());
        assertEquals(rt3.getMaxNum(), rt2.getMaxNum());

        RoomTypeModel rt4 = new RoomTypeModel();
        rt4.setId(rt2.getId());
        rt4.setMessage("hello");
        roomTypeService.modify(rt4);

        RoomTypeModel rt5 = roomTypeService.getByName("TestRT2");
        assertEquals(rt5.getId(), rt2.getId());
        assertEquals(rt5.getMaxNum(), rt2.getMaxNum());
        assertEquals(rt5.getMessage(), rt4.getMessage());

        roomTypeService.remove(rt5);
    }

    //    List<RoomTypeModel> getByCondition(String name,double priceAtMost,int maxNumAtLeast);
    @Test
    public void getByConditionTest() {
        RoomTypeModel rt1 = new RoomTypeModel();
        rt1.setName("TestRT1");
        rt1.setPrice(400);
        rt1.setMaxNum(4);
        roomTypeService.add(rt1);
        RoomTypeModel rt2 = new RoomTypeModel();
        rt2.setName("TestRT2");
        rt2.setPrice(500);
        rt2.setMaxNum(3);
        roomTypeService.add(rt2);
        RoomTypeModel rt3 = new RoomTypeModel();
        rt3.setName("TestRT3");
        rt3.setPrice(600);
        rt3.setMaxNum(2);
        roomTypeService.add(rt3);

        assertTrue(roomTypeService.getByCondition("Test", 0, 0).size()
                == 3);
        assertTrue(roomTypeService.getByCondition("Test", 501, 0).size()
                == 2);
        assertTrue(roomTypeService.getByCondition("Test", 501, 4).size()
                == 1);

        roomTypeService.remove(roomTypeService.getByName("TestRT1"));
        roomTypeService.remove(roomTypeService.getByName("TestRT2"));
        roomTypeService.remove(roomTypeService.getByName("TestRT3"));
    }

}
