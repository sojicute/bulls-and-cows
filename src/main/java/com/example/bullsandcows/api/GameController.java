package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.domain.Stat;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.service.StatService;
import com.example.bullsandcows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;


@Controller
@SessionAttributes("game")
public class GameController {

    @Autowired
    private StatService statService;

    @Autowired
    private UserService userService;

    @GetMapping("/game")
    public String game(@ModelAttribute("game") Game game ) {
        return "game";
    }

    @PostMapping("/game")
    public String play(@AuthenticationPrincipal User user, @ModelAttribute("game") Game game, Model model) {
        game.checkGuess(game.getSecretNumber(), game.getGuessNumber());
        if (game.isCompleted()) {
            Stat stat = statService.findStatByUser(user);

            if (stat == null) {
                stat = new Stat();
            }

            stat.setGameCount(stat.getGameCount()+1);
            stat.setAttemptCount(stat.getAttemptCount()+game.getAttempts().size());
            stat.setAverageAttemptCount(stat.getAttemptCount()* 1.0/stat.getGameCount());
            stat.setUser(userService.findById(user.getId()));
            statService.save(stat);

            model.addAttribute("message", "Success! This number: " +  game.getGuessNumber());
            game.reset();
        }
        return "game";
    }

    @PostMapping("/reset")
    public String reset(@ModelAttribute("game") Game game) {
        game.reset();
        return "game";
    }

    @ModelAttribute("game")
    public Game modelGame() {
        return new Game();
    }
}
