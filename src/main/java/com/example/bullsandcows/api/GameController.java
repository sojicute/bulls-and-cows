package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @GetMapping("/game")
    public String signup(Model model) {;
        model.addAttribute("game", new Game());
        return "game";
    }

    @PostMapping("/game")
    public String game(@ModelAttribute("game") Game game) {
//        System.out.println(game.getSuggestNumber());
//        gameService.game(game.getSuggestNumber());
        HashMap<String, Integer> result = gameService.compareTwoNumber("7328", game.getSuggestNumber().toString());
        System.out.println(result);
        return "game";
    }


}
