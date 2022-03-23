package com.example.bullsandcows.service;

import java.util.HashMap;

public interface GameService {
    void game(Integer suggestNumber);
    HashMap<String, Integer> compareTwoNumber(String hiddenNumber, String suggestNumber);
}
