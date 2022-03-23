package com.example.bullsandcows.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
public class Game {

    @Id
    private Long id;

    private Integer hiddenNumber;
    private Integer suggestNumber;

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

    public Integer getSuggestNumber() {
        return suggestNumber;
    }

    public void setSuggestNumber(Integer suggestNumber) {
        this.suggestNumber = suggestNumber;
    }
}
