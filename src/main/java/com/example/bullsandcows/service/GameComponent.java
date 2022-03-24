package com.example.bullsandcows.service;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Collectors;

//@Component
public class GameComponent {

    private String hiddenNumber;

    private Integer suggestNumber;

    private Integer attemptCount;

    private Boolean isWin;

    private User user;

    private static GameComponent instance = null;

    private GameComponent() {
    }

    public static GameComponent getInstance() {
        if (instance == null) {
            synchronized (GameComponent.class) {
                if( instance == null) {
                    instance = new GameComponent();
                    instance.setHiddenNumber(getHiddenNumber());
                }
            }
        }
        return instance;
    }

    public void setHiddenNumber(String hiddenNumber) {
        this.hiddenNumber = hiddenNumber;
    }

    public Integer getSuggestNumber() {
        return suggestNumber;
    }

    public void setSuggestNumber(Integer suggestNumber) {
        this.suggestNumber = suggestNumber;
    }

    public Integer getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(Integer attemptCount) {
        this.attemptCount = attemptCount;
    }

    public Boolean getWin() {
        return isWin;
    }

    public void setWin(Boolean win) {
        isWin = win;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

//    public void startGame(User user, Integer suggestNumber) {
//        com.example.bullsandcows.domain.Game game = new com.example.bullsandcows.domain.Game();
//        game.setUser(user);
//
//        String hiddenNumber = hiddenNumberGeneration.getHiddenNumber();
//
//        System.out.println(hiddenNumber);
//
//        HashMap<String, Integer> attempt = findBullAndCowBetweenString(hiddenNumber, suggestNumber.toString());
//
//        if (attempt.get(BULL) == 4) {
//            attempts.add(attempt);
//            game.setAttemptCount(attempts.size());
//            game.setIsWin(true);
//            gameService.save(game);
//        } else {
//            attempts.add(attempt);
//        }
//
//        // Поиск среднего числа попыток одного пользователя
////        Integer totalAttempt = user.getGames().stream().map(Game::getAttemptCount).reduce(0, Integer::sum);
////
////        Integer averageAttempt = totalAttempt / user.getGames().size();
//    }


//    public HashMap<String, Integer> findBullAndCowBetweenString(String hiddenNumber, String suggestNumber) {
//
//        HashMap<String, Integer> resultMap = new HashMap<>(Map.of(BULL, 0, COW, 0));
//
//        String[] hiddenArr = hiddenNumber.split("");
//        String[] suggestArr = suggestNumber.split("");
//
//        for (int i = 0; hiddenArr.length > i; i++) {
//            for (int j = 0; suggestArr.length > j; j++) {
//
//                if (hiddenArr[i].equals(suggestArr[j])) {
//
//                    if (j == i) {
//                        resultMap.merge(BULL, 1, Integer::sum);
//                    } else {
//                        resultMap.merge(COW, 1, Integer::sum);
//                    }
//
//                }
//            }
//
//        }
//        return resultMap;
//    }

    public static String getHiddenNumber() {
        List<Integer> ints = new ArrayList<>();
        Random rand = new Random();

        while (ints.size() != 4) {
            int number = rand.nextInt(9);
            if (!ints.contains(number)) {
                ints.add(number);
            }
        }
        return ints.stream().map(Object::toString).collect(Collectors.joining(""));
    }


}
