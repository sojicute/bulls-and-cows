package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Attempt;
import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;

import java.util.List;

public interface AttemptService {
    List<Attempt> findAttemptsByUserAndGame(User user, Game game);
    Attempt createAttempt(User user, Game game, String suggestNumber);
    Attempt checkAttempt(Game game, Attempt attempt);
    Attempt save(Attempt attempt);
}
