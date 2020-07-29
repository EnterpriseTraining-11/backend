package com.github.hieheihei.hotel.order.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.room.model.RoomModel;
import org.apache.ibatis.type.Alias;

import java.util.List;

@Alias("Order")
public class OrderModel {
    //# room_order(id,room_id,start,end,status)
    //# guest_room_order(order_id,guest_id)

    private int id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String start;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private String end;

    private String status; //{预定，入住，结清}

    private RoomModel room;
    private List<GuestModel> guests;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RoomModel getRoom() {
        return room;
    }

    public void setRoom(RoomModel room) {
        this.room = room;
    }

    public List<GuestModel> getGuests() {
        return guests;
    }

    public void setGuests(List<GuestModel> guests) {
        this.guests = guests;
    }
}
