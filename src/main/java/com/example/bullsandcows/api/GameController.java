package com.example.bullsandcows.api;

import com.example.bullsandcows.domain.Game;
import com.example.bullsandcows.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class GameController {

//    @PreAuthorize("hasAnyAuthority('USER')")
    @GetMapping("/games/")
    public String helloUser(){
        return "Hello user";
    }


}
