package com.carta.presentacion.tavo.app.cv.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class PerfilController {
    @GetMapping("perfil")
    public String perfil(Model model){
        model.addAttribute("titulo", "Carta de presentación");
        return "sub/perfil";
    }
}
