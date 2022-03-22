package com.example.bullsandcows.config;

import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        userRepository.save(new User("Michelle", bCryptPasswordEncoder().encode("password")));
        userRepository.save(new User("Angela ", "password"));
        userRepository.save(new User("Kimberly", "password"));
        userRepository.save(new User("Melissa ", "password"));
        userRepository.save(new User("William", "password"));
        userRepository.save(new User("Richard", "password"));
        userRepository.save(new User("Thomas", "password"));
        userRepository.save(new User("Timothy", "password"));
    }
}
