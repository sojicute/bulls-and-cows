package com.example.bullsandcows.service;

import com.example.bullsandcows.repository.GameRepository;
import com.example.bullsandcows.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class GameServiceImpl implements GameService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private GameRepository gameRepository;

    private HiddenNumberGeneration hiddenNumberGeneration;

    private List<HashMap<String, Integer>> attempts = new ArrayList<HashMap<String, Integer>>();

    private final static String BULL = "BULL", COW = "COW";


    public void game(Integer suggestNumber) {
        while (true) {
            HashMap<String, Integer> attempt = compareTwoNumber(hiddenNumberGeneration.getHidden(), suggestNumber.toString());
            if (attempt.get(BULL) == 4) {
                attempts.add(attempt);
                break;
            }
            System.out.println(attempt);
        }
        System.out.println(attempts);

    }


    public HashMap<String, Integer> compareTwoNumber(String hiddenNumber, String suggestNumber) {

        HashMap<String, Integer> resultMap = new HashMap<>(Map.of(BULL, 0, COW, 0));

        String[] hiddenArr = hiddenNumber.split("");
        String[] suggestArr = suggestNumber.split("");

        for (int i = 0; hiddenArr.length > i; i++) {
            for (int j = 0; suggestArr.length > j; j++) {

                if (hiddenArr[i].equals(suggestArr[j])) {

                    if (j == i) {
                        resultMap.merge(BULL, 1, Integer::sum);
                    } else {
                        resultMap.merge(COW, 1, Integer::sum);
                    }

                }
            }

        }
        return resultMap;
    }

}
