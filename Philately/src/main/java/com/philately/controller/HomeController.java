package com.philately.controller;

import com.philately.config.UserSession;

import com.philately.service.StampService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final UserSession userSession;
    private final StampService stampService;

    @GetMapping
    public String homePage(Model model) {
        if (!this.userSession.isUserLogged()) {
            return "index";
        }

        model.addAttribute("userOwnStamps", this.stampService.getAllUserStamps(this.userSession.getId()));
        model.addAttribute("othersStamps", this.stampService.getAllStampsByOthers(this.userSession.getId()));
        return "home";
    }
}
