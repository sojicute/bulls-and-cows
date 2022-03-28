package com.example.bullsandcows.repository;

import com.example.bullsandcows.domain.Stat;
import com.example.bullsandcows.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, Long> {
    Stat findStatByUser(User user);
}
