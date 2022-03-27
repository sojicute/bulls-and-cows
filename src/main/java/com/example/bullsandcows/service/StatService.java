package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Stat;
import com.example.bullsandcows.domain.User;

import java.util.List;

public interface StatService {
    Stat findStatByUser(User user);
    List<Stat> findAll();
    void save(Stat stat);
}
