package com.example.bullsandcows.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer countCow = 0;
    private Integer countBull = 0;

    private String suggestNumber;

    private boolean isMatch;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = true)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
