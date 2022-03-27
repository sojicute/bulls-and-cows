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
import org.springframework.web.bind.annotation.*;


@Controller
@SessionAttributes("game")
public class GameController {

    @Autowired
    private StatService statService;

    @Autowired
    private UserService userService;

    @GetMapping("/game")
    public String game(@ModelAttribute("game") Game game) {
        return "game";
    }

    @PostMapping("/game")
    public String play(@AuthenticationPrincipal User user, @ModelAttribute("game") Game game, Model model) {
        System.out.println(game.getSecretNumber());
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
            model.addAttribute("attempts", game.getAttempts());
            model.addAttribute("message", "Success! This number: " +  game.getGuessNumber());
            game.reset();
        }
        return "game";
    }

    @PostMapping("/reset")
    public String reset(@ModelAttribute("game") Game game) {
        game.reset();
        System.out.println("New secret number "+game.getSecretNumber());
        return "game";
    }

    @ModelAttribute("game")
    public Game modelGame() {
        return new Game();
    }


//    @GetMapping("/games")
//    public String game(Model model) {
//        System.out.println(game.secretNumber);
//        model.addAttribute("game", game);
//        model.addAttribute("attempt", game.getAttempts());
//        return "game";
//    }
//
//    @PostMapping("/games")
//    public String game(@ModelAttribute("attempt") Attempt at, @ModelAttribute("game") NumberGuessingGame game, Model model){
//        System.out.println(game.secretNumber);
////        game.checkAttempt(game.secretNumber, attempt);
////        model.addAttribute("attempt", attempt);
//        return "game";
//    }




//    @GetMapping("/game")
//    public String start() {
//        return "start";
//    }
//
//    @PostMapping("/game")
//    public String createNewGame(@AuthenticationPrincipal User user, Model model) {
//        Game game = gameService.createNewGame(user);
//        model.addAttribute("game", game);
//        return "redirect:/game/" + game.getId();
//    }
//
//
//    @GetMapping("/game/{id}")
//    public ModelAndView getAttempts(@PathVariable("id") Long id, @AuthenticationPrincipal User user){
//        Game game = gameService.findById(id);
//        List<Attempt> attempts = attemptService.findAttemptsByUserAndGame(user, game);
//        ModelAndView mav = new ModelAndView("game");
//        mav.addObject("game", game);
//        mav.addObject("attempts", attempts);
//        mav.addObject("attempt", new Attempt());
//        return mav;
//    }
//
//
//    @PostMapping("/game/{id}")
//    public String submitAttempts(@PathVariable("id") Long id,
//                                 @AuthenticationPrincipal User user,
//                                 @ModelAttribute("game") Game g,
//                                 @ModelAttribute("attempt") @Valid Attempt attempt,
//                                 BindingResult result) {
//
//        if (result.hasErrors()) {
//            return "redirect:/game/"+ id;
//        }
//
//        System.out.println("Подсказка: " +g.getSecretNumber());
//        Game game = gameService.findById(id);
//
//        Attempt newAttempt = attemptService.createAttempt(user, game, attempt.getSuggestNumber());
//        attemptService.checkAttempt(game, newAttempt);
//        return "redirect:/game/"+ id;
//    }

}
