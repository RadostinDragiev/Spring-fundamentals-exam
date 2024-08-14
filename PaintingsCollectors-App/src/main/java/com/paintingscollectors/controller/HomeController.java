package com.paintingscollectors.controller;

import com.paintingscollectors.service.PaintingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final PaintingService paintingService;

    @GetMapping
    public String home(HttpSession httpSession, Model model) {
        if (httpSession.getAttribute("username") == null) {
            return "index";
        }

        model.addAttribute("ownPaintings", paintingService.getAllByUsername(String.valueOf(httpSession.getAttribute("username"))));
        return "home";
    }
}
