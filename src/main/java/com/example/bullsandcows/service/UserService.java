package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.dto.UserDto;
import com.example.bullsandcows.exception.UserAlreadyExistException;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {
    User save(UserDto userDto) throws UserAlreadyExistException;
    List<User> findAll();
}
