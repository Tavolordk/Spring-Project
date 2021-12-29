package com.tavo.spring.application.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequestMapping("/variables")
public class EjemploVariableRutasController {

    @GetMapping("/")
    public String index(Model model) {
        return "variables/index";
    }
    

    @GetMapping("/string/{texto}")
    public String variables(@PathVariable String texto, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta(@PathVariable)");
        model.addAttribute("resultado", "Resultado: " + texto);
        return "variables/ver";
    }
    
    @GetMapping("/string/{texto}/{numero}")
    public String variables(@PathVariable String texto,@PathVariable Integer numero, Model model) {
        model.addAttribute("titulo", "Recibir parámetros de la ruta(@PathVariable)");
        model.addAttribute("resultado", "Resultado: " + texto + ' ' + numero);
        return "variables/ver";
    }
}
