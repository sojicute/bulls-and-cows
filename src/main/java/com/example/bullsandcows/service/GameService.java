package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;

import java.util.HashMap;
import java.util.List;

public interface GameService {
    Game createNewGame(User user);
    Game findById(Long id);
}
