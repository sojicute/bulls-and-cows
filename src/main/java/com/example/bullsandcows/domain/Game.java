package com.example.bullsandcows.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer hiddenNumber;
    private Integer suggestNumber;

    private Integer attemptCount;

    private Boolean isWin;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=true)
    private User user;
}
