package com.philately.controller;

import com.philately.config.UserSession;
import com.philately.model.entity.Stamp;
import com.philately.service.StampService;
import com.philately.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserSession userSession;
    private final StampService stampService;

    @PostMapping("/add-to-wishlist/{stampUUID}")
    public String addToWishlist(@PathVariable String stampUUID) {
        if (!this.userSession.isUserLogged()) {
            return "index";
        }

        Stamp stamp = this.stampService.getStampById(stampUUID);
        this.userService.addStampToWishList(stamp);
        return "redirect:/";
    }

    @PostMapping("/remove-from-wishlist/{stampUUID}")
    public String removeFromWishlist(@PathVariable String stampUUID) {
        if (!this.userSession.isUserLogged()) {
            return "index";
        }

        this.userService.removeFromWishlist(stampUUID);
        return "redirect:/";
    }

    @PostMapping("/by-all")
    public String byAllStamps() {
        if (!this.userSession.isUserLogged()) {
            return "index";
        }

        this.userService.byAllStamps();
        return "redirect:/";
    }
}
