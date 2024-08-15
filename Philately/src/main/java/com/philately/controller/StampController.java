package com.philately.controller;

import com.philately.config.UserSession;
import com.philately.model.dto.AddStampDto;
import com.philately.model.entity.PaperName;
import com.philately.service.StampService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/stamps")
@RequiredArgsConstructor
public class StampController {

    private final UserSession userSession;
    private final StampService stampService;

    @ModelAttribute("addStampDto")
    public AddStampDto addStampDto() {
        return new AddStampDto();
    }

    @GetMapping("/add-stamp")
    public String getAddStampPage(Model model) {
        if (!userSession.isUserLogged()) {
            return "redirect:/";
        }
        model.addAttribute("paperNames", PaperName.values());
        return "add-stamp";
    }

    @PostMapping("/add-stamp")
    public String addStamp(@Valid AddStampDto addStampDto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (!this.userSession.isUserLogged()) {
            return "index";
        }

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("addStampDto", addStampDto);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.addStampDto", bindingResult);
            return "redirect:/stamps/add-stamp";
        }

        this.stampService.addStamp(addStampDto);
        return "redirect:/";
    }
}
