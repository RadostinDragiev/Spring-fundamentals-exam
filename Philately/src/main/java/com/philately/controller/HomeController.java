package com.philately.controller;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String homePage(HttpSession httpSession) {
        if (httpSession.getAttribute("username") == null) {
            return "index";
        }

        return "home";
    }
}
