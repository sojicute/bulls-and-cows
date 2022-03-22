package com.example.bullsandcows.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Game {

    @Id
    private Long id;

    private Integer hiddenNumber;
    private Integer counter;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHiddenNumber() {
        return hiddenNumber;
    }

    public void setHiddenNumber(Integer hiddenNumber) {
        this.hiddenNumber = hiddenNumber;
    }

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
