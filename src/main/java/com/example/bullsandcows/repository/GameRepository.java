package com.example.bullsandcows.repository;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {
    Game findByUserAndId(User user, Long id);

}
