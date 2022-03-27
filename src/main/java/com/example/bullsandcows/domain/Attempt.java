package com.example.bullsandcows.domain;

public class Attempt {

    private Integer cowCount = 0;
    private Integer bullCount = 0;

//    @NotEmpty(message = "Number cannot be empty")
//    @Size(min = 4, max=4, message = "Number must have at least 4 characters ")
//    private String suggestNumber;


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
}
