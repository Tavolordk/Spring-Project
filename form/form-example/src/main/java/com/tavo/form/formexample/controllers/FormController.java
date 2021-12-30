package com.tavo.form.formexample.controllers;

import com.tavo.form.formexample.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("titulo", "Formulario usuarios");
        return "form";
    }

    @PostMapping("/form")
    /*
     * public String procesar(Model model,
     * 
     * @RequestParam String username,
     * 
     * @RequestParam String password,
     * 
     * @RequestParam String email)
     */
    /*
     * Podemos reducir todo este código y dejarlo
     * más simplificado gracias al propio framework
     * Usuario usuario = new Usuario();
     * usuario.setUsername(username);
     * usuario.setPassword(password);
     * usuario.setEmail(email);
     */
    public String procesar(Model model, Usuario usuario) {

        model.addAttribute("titulo", "Resultado del formulario");
        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
