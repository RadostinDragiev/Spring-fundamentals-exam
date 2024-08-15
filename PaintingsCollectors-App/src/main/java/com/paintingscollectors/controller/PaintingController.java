package com.paintingscollectors.controller;

import com.paintingscollectors.model.dto.AddPaintingDto;
import com.paintingscollectors.model.entity.StyleName;
import com.paintingscollectors.service.PaintingService;
import com.paintingscollectors.util.SessionUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/paintings")
@RequiredArgsConstructor
public class PaintingController {

    private final PaintingService paintingService;
    private final SessionUtils sessionUtils;

    @GetMapping
    public String addPaintingPage(HttpSession httpSession, @ModelAttribute("addPaintingDto") AddPaintingDto addPaintingDto, Model model) {
        if (httpSession.getAttribute("username") == null) {
            return "redirect:/";
        }
        model.addAttribute("styles", StyleName.values());
        return "add-painting";
    }

    @PostMapping
    public String addPainting(@Valid @ModelAttribute("addPaintingDto") AddPaintingDto addPaintingDto, BindingResult bindingResult, HttpSession httpSession) {
        if (bindingResult.hasErrors()) {
            bindingResult.getAllErrors()
                    .forEach(err -> {
                        FieldError fieldError = (FieldError) err;
                        httpSession.setAttribute(fieldError.getField() + "Err", fieldError.getDefaultMessage());
                    });
            return "redirect:/paintings";
        }
        this.sessionUtils.clearErrorMessages(httpSession);

        this.paintingService.addPainting(addPaintingDto);
        return "redirect:/";
    }

    @PostMapping("/vote/addFavorite/{paintingUUID}")
    public String addToFavorite(@PathVariable String paintingUUID, HttpSession httpSession) {
        String username = String.valueOf(httpSession.getAttribute("username"));

        this.paintingService.addToFavorite(username, paintingUUID);
        return "redirect:/";
    }

    @PostMapping("/vote/{paintingUUID}")
    public String votePainting(@PathVariable String paintingUUID, HttpSession httpSession) {
        String username = String.valueOf(httpSession.getAttribute("username"));

        this.paintingService.addVote(username, paintingUUID);
        return "redirect:/";
    }

    @PostMapping("/remove/{paintingUUID}")
    public String removePainting(@PathVariable String paintingUUID, HttpSession httpSession) {
        this.paintingService.removePainting(paintingUUID);
        return "redirect:/";
    }
}
