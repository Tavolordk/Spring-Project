package com.tavo.form.formexample.controllers;

import javax.validation.Valid;

import com.tavo.form.formexample.models.domain.Usuario;
import com.tavo.form.formexample.validation.UsuarioValidador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("usuario")
public class FormController {
    @Autowired
    private UsuarioValidador validador;

    @InitBinder
    public void initBinder(WebDataBinder binder){
         binder.addValidators(validador);
    }

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
    public String procesar(@Valid Usuario usuario, BindingResult result,Model model, SessionStatus sessionStatus) {

        //validador.validate(usuario, result);
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

        /**Session status mantiene los datos que no aparecen en el formulario pero ya están contenidos en la
         * clase
         */
        model.addAttribute("usuario", usuario);
        sessionStatus.setComplete();
        return "resultado";
    }
}
