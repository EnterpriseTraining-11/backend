package com.github.hieheihei.hotel.guest.service;

import com.github.hieheihei.hotel.guest.model.GuestModel;

import java.util.List;

public interface IGuestService {

    void add(GuestModel gm);

    void remove(GuestModel gm);

    void modify(GuestModel gm);

    List<GuestModel> getByAll();

}
