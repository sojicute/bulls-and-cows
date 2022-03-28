package com.example.bullsandcows.domain;


/**
 * Класс "попытка" для хранение переменных cowCount и bullCount
 * @autor sojicute
*/
public class Attempt {

    /** Поле подсчета COW */
    private Integer cowCount = 0;
    /** Поле подсчета BULL */
    private Integer bullCount = 0;

    /** Поле для хранения текущего варианта числа */
    private String currentGuessNumber;

    public Integer getCowCount() {
        return cowCount;
    }

    public void setCowCount(Integer cowCount) {
        this.cowCount = cowCount;
    }

    public Integer getBullCount() {
        return bullCount;
    }

    public void setBullCount(Integer bullCount) {
        this.bullCount = bullCount;
    }

    public String getCurrentGuessNumber() {
        return currentGuessNumber;
    }

    public void setCurrentGuessNumber(String currentGuessNumber) {
        this.currentGuessNumber = currentGuessNumber;
    }
}
