package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.dto.UserDto;
import com.example.bullsandcows.exception.UserAlreadyExistException;
import com.example.bullsandcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null ) {
            throw new UsernameNotFoundException("User not found");
        } else {
            return user;
        }
    }

    @Override
    public User save(UserDto userDto) throws UserAlreadyExistException {

        if (usernameExist(userDto.getUsername())) {
            throw new UserAlreadyExistException("There is an account with that username: " +userDto.getUsername());
        }

        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(bCryptPasswordEncoder.encode(userDto.getPassword()));
        return userRepository.save(user);
    }

    private boolean usernameExist(String username) {
        return userRepository.findByUsername(username) != null;
    }
}
