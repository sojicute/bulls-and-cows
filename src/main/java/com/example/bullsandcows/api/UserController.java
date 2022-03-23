package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.User;
import com.example.bullsandcows.dto.UserDto;
import com.example.bullsandcows.exception.UserAlreadyExistException;
import com.example.bullsandcows.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/home";
    }

    @RequestMapping("/game")
    public String game() {
        return "/game";
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
