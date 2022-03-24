package com.example.bullsandcows.repository;

import com.example.bullsandcows.domain.Attempt;
import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttemptRepository extends JpaRepository<Attempt, Long> {
    List<Attempt> findAttemptsByUserAndGame(User user, Game game);
}
