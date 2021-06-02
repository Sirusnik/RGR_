package com.example.demo.service;

import com.example.demo.entity.Hotel;

public interface HotelService extends GeneralService <Hotel>{
    Hotel findByName(String name);
}
