package com.example.bullsandcows.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Класс описывает некоторые процессы игры
 * @autor sojicute
 */
public class Game {

    /** Поле генерируемой строки */
    private String secretNumber;

    /** Поле со значением строки от пользователя */
    private String guessNumber;

    /** Поле проверки завершение игры */
    private boolean isCompleted;

    /** Поле для хранения попыток */
    private final List<Attempt> attempts = new ArrayList<>();

    /**
     * Конструктор запускает функцию {@link Game#start()}
     */
    public Game() {
        start();
    }

    /**
     * Функция устанавливает значение полей
     * {@link Game#secretNumber}
     * {@link Game#attempts}
     * {@link Game#isCompleted}
     */
    private void start() {
        secretNumber = generateSecretString();
        attempts.clear();
        isCompleted = false;
    }

    /**
     * Функция сбрасывает значение поля {@link Game#secretNumber} и генириует новое.
     * {@link Game#start()}
     */
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

    /**
     * Функция проверяет совпадают ли строки {@link Game#secretNumber} и {@link Game#guessNumber}
     * В случае удачной попытки завершает игру {@link Game#isCompleted}
     * @param secretNumber
     * @param guessNumber
     */
    public void checkGuess(String secretNumber, String guessNumber) {

        Attempt attempt = new Attempt();
        attempt.setCurrentGuessNumber(guessNumber);

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
    }

    /**
     * Функция генерирует случайное четырехзначное число без повторения цифр и конвертирует его в строку.
     * @return возвращает строку для {@link Game#secretNumber}
     */
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
