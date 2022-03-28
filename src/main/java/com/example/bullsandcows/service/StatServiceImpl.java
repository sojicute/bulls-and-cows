package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Stat;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.repository.StatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatServiceImpl implements StatService {

    @Autowired
    private StatRepository statRepository;

    @Override
    public Stat findStatByUser(User user) {
        return statRepository.findStatByUser(user);
    }

    @Override
    public List<Stat> findAll() {
        return statRepository.findAll();
    }

    @Override
    public void save(Stat stat) {
        statRepository.save(stat);
    }
}
