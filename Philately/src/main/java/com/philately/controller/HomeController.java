package com.philately.controller;

import com.philately.config.UserSession;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserSession userSession;

    @GetMapping
    public String homePage() {
        if (!userSession.isUserLogged()) {
            return "index";
        }

        return "home";
    }
}
