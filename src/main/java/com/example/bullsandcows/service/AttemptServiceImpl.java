package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Attempt;
import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.repository.AttemptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttemptServiceImpl implements AttemptService {

    @Autowired
    private AttemptRepository attemptRepository;

    @Autowired
    private GameService gameService;

    @Override
    public List<Attempt> findAttemptsByUserAndGame(User user, Game game) {
        return attemptRepository.findAttemptsByUserAndGame(user, game);
    }

    @Override
    public Attempt createAttempt(User user, Game game, String suggestNumber) {
        Attempt attempt = new Attempt();
        attempt.setUser(user);
        attempt.setGame(game);
        attempt.setSuggestNumber(suggestNumber);
        return attemptRepository.save(attempt);
    }

    @Override
    public Attempt checkAttempt(Game game, Attempt attempt) {

        String[] secretArr = game.getSecretNumber().split("");
        String[] suggestArr = attempt.getSuggestNumber().split("");

        for (int i = 0; secretArr.length > i; i++) {
            for (int j = 0; suggestArr.length > j; j++) {
                if (secretArr[i].equals(suggestArr[j])) {
                    if (j == i) {
                        attempt.setCountBull(attempt.getCountBull()+1);
                    } else {
                        attempt.setCountCow(attempt.getCountCow()+1);
                    }
                }
            }
        }

        if (attempt.getCountBull() == 4) {
            attempt.setMatch(true);
        }
        return attemptRepository.save(attempt);
    }

    @Override
    public Attempt save(Attempt attempt) {
        return attemptRepository.save(attempt);
    }

}
