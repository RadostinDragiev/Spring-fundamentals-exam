package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.AuthUserDto;
import com.paintingscollectors.model.dto.LoggedUserDto;
import com.paintingscollectors.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage(HttpSession httpSession, AuthUserDto authUserDto) {
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("authUserDto") AuthUserDto authUserDto, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            httpSession.setAttribute("errMsg", bindingResult.getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.toList()));
            return "redirect:/login";
        }

        LoggedUserDto user = this.userService.findUser(authUserDto);

        if (user == null) {
            httpSession.setAttribute("invalidUser", "Invalid user or password");
            return "redirect:/login";
        }

        httpSession.setAttribute("username", user.getUsername());
        return "home";
    }

    @RequestMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }
}
