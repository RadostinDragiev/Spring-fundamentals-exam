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
        Object username = httpSession.getAttribute("username");
        if (username == null) {
            return "index";
        }

        model.addAttribute("ownPaintings", this.paintingService.getAllByUsername(String.valueOf(username)));
        model.addAttribute("othersPaintings", this.paintingService.getOthersPaintings(String.valueOf(username)));
        model.addAttribute("ownFavoritePaintings", this.paintingService.getOwnFavoritePaintings(String.valueOf(username)));
        model.addAttribute("mostVotedPaintings", this.paintingService.getMostRatedPaintings());
        return "home";
    }
}
