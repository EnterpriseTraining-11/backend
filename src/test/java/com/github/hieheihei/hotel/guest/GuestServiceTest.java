package com.github.hieheihei.hotel.guest;

import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.guest.service.IGuestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
public class GuestServiceTest {

    private IGuestService guestService;

    @Autowired
    public GuestServiceTest(IGuestService guestService) {
        this.guestService = guestService;
    }

    @Test
    public void addAndRemoveTest() {
        GuestModel gm1 = new GuestModel();
        gm1.setIdCard("test1");
        gm1.setGender("女");
        gm1.setName("龙龙");
        gm1.setPhone("10086");
        guestService.add(gm1);

        GuestModel gm2 = guestService.getByIdCard("test1");
        assertNotNull(gm2);

        guestService.remove(gm2);
        assertNull(guestService.getByIdCard("test1"));
    }

    @Test
    public void modifyTest() {
        GuestModel gm1 = new GuestModel();
        gm1.setIdCard("test1");
        gm1.setGender("女");
        gm1.setName("龙龙");
        gm1.setPhone("10086");
        guestService.add(gm1);

        GuestModel gm2 = guestService.getByIdCard("test1");
        gm2.setPhone("2");
        gm2.setGender("不男");
        guestService.modify(gm2);

        GuestModel gm3 = guestService.getById(gm2.getId());
        assertEquals(gm2.getPhone(), gm3.getPhone());
        assertEquals(gm2.getGender(), gm3.getGender());

        guestService.remove(gm3);
    }

    @Test
    public void getByConditionTest() {
        GuestModel gm1 = new GuestModel();
        gm1.setIdCard("test1");
        gm1.setGender("女");
        gm1.setName("龙龙");
        gm1.setPhone("11");
        guestService.add(gm1);

        GuestModel gm2 = new GuestModel();
        gm2.setIdCard("test2");
        gm2.setGender("女");
        gm2.setName("丽丽");
        gm2.setPhone("22");
        guestService.add(gm2);

        GuestModel gm3 = new GuestModel();
        gm3.setIdCard("test3");
        gm3.setGender("男");
        gm3.setName("丽丽丽丽");
        gm3.setPhone("33");
        guestService.add(gm3);

        assertTrue(guestService.getByCondition(null, "龙", "女", null).size()
                == 1);
        assertTrue(guestService.getByCondition("test2", null, "女", null).size()
                == 1);
        assertTrue(guestService.getByCondition(null, "丽", null, null).size()
                == 2);

        guestService.remove(guestService.getByIdCard("test1"));
        guestService.remove(guestService.getByIdCard("test2"));
        guestService.remove(guestService.getByIdCard("test3"));
    }

}
