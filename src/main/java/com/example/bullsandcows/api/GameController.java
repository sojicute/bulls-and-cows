package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;


    @GetMapping("/game/create")
    public String signup(@AuthenticationPrincipal User user, Model model) {;
        Game game = gameService.createNewGame(user);
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/game/create")
    public String createNewGame(@AuthenticationPrincipal User user, Model model) {
        Game game = gameService.createNewGame(user);
        model.addAttribute("game", game);
        return "game";
    }


    @GetMapping ("/game/{id}")
    public String game(@RequestParam("id") Long id, @AuthenticationPrincipal User user, Model model) {
        Game game = gameService.findById(id);
        model.addAttribute("game", game);
        return "game";
    }

    @PostMapping("/game/{id}")
    public String sendSuggestNumber(@ModelAttribute("game") Game game, Model model) {

        return "game";
    }

    @PostMapping("/game")
    public String game(@AuthenticationPrincipal User user, @ModelAttribute("game") Game game, Model model) {

//        gameService.startGame(user, game.getSuggestNumber());


//        List<HashMap<String, Integer>> results = gameService.s(game.getSuggestNumber());

//        results.stream()
//                .map(result -> result.keySet().stream().map(key -> key +"" + result.get(key))
//                        .collect(Collectors.joining(" ", "", "")))
//                            .collect(Collectors.toList());
//
//        System.out.println(user.getUsername());
//
//        model.addAttribute("results", gameService.getAttempts());
        return "game";
    }


}
