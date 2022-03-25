package com.example.bullsandcows.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Attempt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer countCow = 0;
    private Integer countBull = 0;

    @NotEmpty(message = "Number cannot be empty")
    @Size(min = 4, max=4, message = "Number must have at least 4 characters ")
    private String suggestNumber;

    private boolean isMatch;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = true)
    private Game game;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = true)
    private User user;

}
