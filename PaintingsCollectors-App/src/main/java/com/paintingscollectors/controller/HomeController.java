package com.paintingscollectors.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    @GetMapping
    public String home(HttpSession httpSession) {
        if (httpSession.getAttribute("username") == null) {
            return "index";
        }
        return "home";
    }
}
