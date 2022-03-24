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
    public Game findByUserAndId(User user, Long id) {
        return gameRepository.findByUserAndId(user, id);
    }

    @Override
    public Game createNewGame(User user) {
        Game game = new Game();
        game.setUser(user);
        game.setSecretNumber(getSecretNumber());
        System.out.println(game.getSecretNumber());
        return gameRepository.save(game);
    }


    @Override
    public Game findById(Long id) {
        return gameRepository.findById(id).get();
    }


    private String getSecretNumber() {
        List<Integer> ints = new ArrayList<>();
        Random rand = new Random();
        while (ints.size() != 4) {
            int number = rand.nextInt(9);
            if (!ints.contains(number)) {
                ints.add(number);
            }
        }
        return ints.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
