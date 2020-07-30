package com.github.hieheihei.hotel.guest.service;

import com.github.hieheihei.hotel.guest.model.GuestModel;

import java.util.List;

public interface IGuestService {

    void add(GuestModel gm);

    void remove(GuestModel gm);

    void modify(GuestModel gm);

    /**
     *
     * @param gm
     * @return merged guest
     */
    GuestModel merge(GuestModel gm);

    List<GuestModel> getByAll();

    GuestModel getById(int id);

    GuestModel getByIdCard(String idCard);

    List<GuestModel> getByCondition(String idCard, String name, String gender, String phone);

}
