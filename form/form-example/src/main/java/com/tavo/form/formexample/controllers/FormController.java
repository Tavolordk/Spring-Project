package com.tavo.form.formexample.controllers;

import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import com.tavo.form.formexample.models.domain.Usuario;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FormController {

    @GetMapping("/form")
    public String form(Model model) {
        Usuario usuario = new Usuario();

        model.addAttribute("usuario", usuario);
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
    public String procesar(@Valid Usuario usuario, BindingResult result,Model model) {

        model.addAttribute("titulo", "Resultado del formulario");

        if(result.hasErrors()){
            /* Map<String,String> errores = new HashMap<>();
            result.getFieldErrors().forEach(err ->{
                errores.put(err.getField(), "El campo ".concat(err.getField()).concat(" ").concat(err.getDefaultMessage()));
            });
            model.addAttribute("error", errores); 
            Se puede automatizar este parte gracias a spring*/
            return "form";
        }

        model.addAttribute("usuario", usuario);

        return "resultado";
    }
}
