package com.example.bullsandcows.domain;

import lombok.*;
import org.springframework.beans.factory.annotation.Lookup;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;


public class Game {

    private String secretNumber;

    private String guessNumber;

    private boolean isCompleted;

    private final List<Attempt> attempts = new ArrayList<>();

    public Game() {
        start();
    }

    private void start() {
        secretNumber = generateSecretString();
        attempts.clear();
        isCompleted = false;
    }

    public void reset() {
        start();
    }

    public String getSecretNumber() {
        return secretNumber;
    }

    public void setSecretNumber(String secretNumber) {
        this.secretNumber = secretNumber;
    }

    public String getGuessNumber() {
        return guessNumber;
    }

    public void setGuessNumber(String guessNumber) {
        this.guessNumber = guessNumber;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public List<Attempt> getAttempts() {
        return attempts;
    }

    public Boolean checkGuess(String secretNumber, String guessNumber) {

        Attempt attempt = new Attempt();

        String[] secretArr = secretNumber.split("");
        String[] guessArr = guessNumber.split("");

        for (int i = 0; secretArr.length > i; i++) {
            for (int j = 0; guessArr.length > j; j++) {
                if (secretArr[i].equals(guessArr[j])) {
                    if (j == i) {
                        attempt.setBullCount(attempt.getBullCount()+1);
                    } else {
                        attempt.setCowCount(attempt.getCowCount()+1);
                    }
                }
            }
        }

        attempts.add(attempt);

        if (attempt.getBullCount() == 4) {
            isCompleted = true;
        }
        return true;
    }

    private static String generateSecretString() {
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
