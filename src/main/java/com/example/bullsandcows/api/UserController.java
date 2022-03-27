package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Stat;
import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.dto.UserDto;
import com.example.bullsandcows.exception.UserAlreadyExistException;
import com.example.bullsandcows.service.StatService;
import com.example.bullsandcows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private StatService statService;

    @GetMapping("/home")
    public String home(Model model) {
        List<Stat> stats = statService.findAll();

        Comparator<Stat> comparator = Comparator.comparingInt(Stat::getGameCount);
        comparator = comparator.thenComparing(Comparator.comparingDouble(Stat::getAverageAttemptCount).reversed());

        List<Stat> sortedStat = stats.stream().sorted(comparator).collect(Collectors.toList());

        model.addAttribute("stats", sortedStat);
        return "/home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }


    @GetMapping("/signup")
    public String signup(Model model) {
        UserDto userDto = new UserDto();
        model.addAttribute("user", userDto);
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result) {

        if (result.hasErrors()) {
            return "signup";
        }

        if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
            result.rejectValue("password", "error.user", "");
            result.rejectValue("matchingPassword", "error.user", "Passwords do not match");
            return "signup";
        }

        try {
            userService.save(userDto);
        } catch (UserAlreadyExistException ex) {
            result.rejectValue("username", "error.user", ex.getMessage());
            return "signup";
        }

        return "redirect:/home";
    }

}
