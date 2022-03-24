package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Attempt;
import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.service.AttemptService;
import com.example.bullsandcows.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private AttemptService attemptService;


    @GetMapping("/game")
    public String start() {
        return "start";
    }

    @PostMapping("/game")
    public String createNewGame(@AuthenticationPrincipal User user, Model model) {
        Game game = gameService.createNewGame(user);
        model.addAttribute("game", game);
        return "redirect:/game/" + game.getId();
    }


    @GetMapping("/game/{id}")
    public String startGame(@PathVariable("id") Long id, @AuthenticationPrincipal User user, Model model) {
        Game game = gameService.findByUserAndId(user, id);
        List<Attempt> attempts = attemptService.findAttemptsByUserAndGame(user, game);

        System.out.println(attempts);

        model.addAttribute("attempts", attempts);
        return "game";
    }

    @PostMapping ("/game/{id}")
    public String suggestNumber(@PathVariable("id") Long id, @AuthenticationPrincipal User user, @ModelAttribute("at") Attempt at, Model model) {
        Game game = gameService.findById(id);
        Attempt attempt = attemptService.createAttempt(user, game, at.getSuggestNumber());
        attemptService.checkAttempt(game, attempt);
        List<Attempt> attempts = attemptService.findAttemptsByUserAndGame(user, game);
        model.addAttribute("attempts", attempts);
        return "game";
    }

}
