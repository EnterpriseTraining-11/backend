package com.github.hieheihei.hotel.guest.service.impl;

import com.github.hieheihei.hotel.guest.mapper.IGuestMapper;
import com.github.hieheihei.hotel.guest.model.GuestModel;
import com.github.hieheihei.hotel.guest.service.IGuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GuestServiceImpl implements IGuestService {

    private final IGuestMapper guestMapper;

    @Autowired
    public GuestServiceImpl(IGuestMapper guestMapper) {
        this.guestMapper = guestMapper;
    }

    @Override
    public void add(GuestModel gm) {
        guestMapper.insert(gm);
    }

    @Override
    public void remove(GuestModel gm) {
        guestMapper.delete(gm);
    }

    @Override
    public void modify(GuestModel gm) {
        guestMapper.update(gm);
    }

    @Override
    public GuestModel merge(GuestModel gm) {
        if (getByIdCard(gm.getIdCard()) == null) {
            add(gm);
        } else {
            modify(gm);
        }
        return getByIdCard(gm.getIdCard());
    }

    @Override
    public List<GuestModel> getByAll() {
        return guestMapper.selectByAll();
    }

    @Override
    public GuestModel getById(int id) {
        return guestMapper.selectById(id);
    }

    @Override
    public GuestModel getByIdCard(String idCard) {
        return guestMapper.selectByIdCard(idCard);
    }

    @Override
    public List<GuestModel> getByCondition(String idCard, String name, String gender, String phone) {
        return guestMapper.selectByCondition(idCard, name, gender, phone);
    }
}
