package com.example.bullsandcows.config;

import com.example.bullsandcows.domain.Role;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.repository.RoleRepository;
import com.example.bullsandcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Role role = roleRepository.save(new Role(1L, "ROLE_USER"));

        Set<Role> roles = Collections.singleton(role);

        String password = bCryptPasswordEncoder().encode("password");

        userRepository.save(new User("Michelle", password, roles));
        userRepository.save(new User("Angela", password, roles));
        userRepository.save(new User("Kimberly", password, roles));
        userRepository.save(new User("Melissa", password, roles));
        userRepository.save(new User("William", password, roles));
        userRepository.save(new User("Richard", password, roles));
        userRepository.save(new User("Thomas", password, roles));
        userRepository.save(new User("Timothy", password,roles));
    }
}
