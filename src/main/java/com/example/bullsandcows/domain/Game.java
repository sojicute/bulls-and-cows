package com.example.bullsandcows.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String secretNumber;

    private Boolean isWin;


    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;
}
