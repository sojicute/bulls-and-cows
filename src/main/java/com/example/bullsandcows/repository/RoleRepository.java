package com.example.bullsandcows.repository;

import com.example.bullsandcows.domain.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
