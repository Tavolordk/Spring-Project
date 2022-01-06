package com.carta.presentacion.tavo.app.cv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class IndexController {
    @GetMapping("home")
    public String home(Model model){
        model.addAttribute("titulo", "Carta de presentación");
        return "home";
    }

}
