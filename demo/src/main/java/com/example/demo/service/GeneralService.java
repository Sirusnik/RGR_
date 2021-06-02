package com.example.demo.service;

import java.util.List;

public interface GeneralService<T> {

    void save(T t);

    List<T> findAll();

    T findById(Long id);

    void delete(Long id);
}
