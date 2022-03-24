package com.example.bullsandcows.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Component
@SessionScope
public class HiddenNumberGeneration {

    List<Integer> ints = new ArrayList<>();
    Random rand = new Random();

    String getHiddenNumber() {

        while (ints.size() != 4) {
            int number = rand.nextInt(9);
            if (!ints.contains(number)) {
                ints.add(number);
            }
        }
        return ints.stream().map(Object::toString).collect(Collectors.joining(""));
    }
}
