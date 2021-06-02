package com.example.demo.service;

import com.example.demo.entity.Client;

public interface ClientService extends GeneralService <Client>{

    Client findByName(String name);

    Client findByAdress(String adress);

}
