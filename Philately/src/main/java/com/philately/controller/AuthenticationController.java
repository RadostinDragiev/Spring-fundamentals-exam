package com.philately.controller;

import com.philately.model.dto.AuthenticateUserDto;
import com.philately.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService userService;

    @ModelAttribute("authenticateUserDto")
    public AuthenticateUserDto authenticateUserDto() {
        return new AuthenticateUserDto();
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@Valid AuthenticateUserDto authenticateUserDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("authenticateUserDto", authenticateUserDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.authenticateUserDto", bindingResult);
            return "redirect:/auth/login";
        }

        boolean isUserFound = this.userService.loginUser(authenticateUserDto);
        if (!isUserFound) {
            redirectAttributes.addFlashAttribute("authenticateUserDto", authenticateUserDto);
            redirectAttributes.addFlashAttribute("userNotFound", true);
            return "redirect:/auth/login";
        }

        return "redirect:/";
    }

    @GetMapping("/register")
    public String getRegisterPage() {
        return "register";
    }

    @GetMapping("/logout")
    public String logout() {
        // TODO: delete all users wishedStamps;
        return "redirect:/";
    }
}
