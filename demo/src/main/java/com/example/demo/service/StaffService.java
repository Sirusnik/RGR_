package com.example.demo.service;

import com.example.demo.entity.Staff;

public interface StaffService extends GeneralService <Staff>{
    Staff findByName(String name);
}
