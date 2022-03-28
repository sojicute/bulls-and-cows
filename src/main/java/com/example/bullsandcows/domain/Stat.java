package com.example.bullsandcows.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Stat {
    @Id
    private long id;

    private int gameCount;

    private int attemptCount;

    private double averageAttemptCount;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "user_id")
    private User user;

}
