package com.example.bullsandcows.domain;

public class Attempt {

    private Integer cowCount = 0;
    private Integer bullCount = 0;

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
