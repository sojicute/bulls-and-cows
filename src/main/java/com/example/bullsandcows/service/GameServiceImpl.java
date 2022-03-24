package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.repository.GameRepository;
import com.example.bullsandcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private UserService userService;

    @Autowired
    private GameRepository gameRepository;


    @Override
    public Game createNewGame(User user) {
        Game game = new Game();
        game.setUser(user);
        game.setHiddenNumber(1234);
        return gameRepository.save(game);
    }

    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }
}
