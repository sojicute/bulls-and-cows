package com.example.bullsandcows.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class HiddenNumberGeneration {

    List<Integer> ints = new ArrayList<>();
    Random rand = new Random();

    String getHidden() {

        while (ints.size() != 4) {
            int number = rand.nextInt(9);
            if (!ints.contains(number)) {
                ints.add(number);
            }
        }
        return ints.stream().map(Object::toString).collect(Collectors.joining(", "));
    }
}
