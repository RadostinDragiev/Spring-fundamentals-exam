package com.philately.controller;

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
    private final StampService stampService;

    @PostMapping("/add-to-wishlist/{stampUUID}")
    public String addToWishlist(@PathVariable String stampUUID) {
        Stamp stamp = this.stampService.getStampById(stampUUID);
        this.userService.addStampToWishList(stamp);
        return "redirect:/";
    }

    @PostMapping("/remove-from-wishlist/{stampUUID}")
    public String removeFromWishlist(@PathVariable String stampUUID) {
        this.userService.removeFromWishlist(stampUUID);
        return "redirect:/";
    }

    @PostMapping("/by-all")
    public String byAllStamps() {
        this.userService.byAllStamps();
        return "redirect:/";
    }
}
