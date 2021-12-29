package com.tavo.spring.application.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
    /**El redirect nos permite especificar una ruta en el mapping
     * *en este caso GetMapping para que sea redirigido a otra ruta
     * *que nosotros deseemos asociar y cambia la url completa a esa
     * *ruta indicada mientras que forward la url que se asocia
     * *queda igual.
     */
    @GetMapping("/")
    public String home(){
        //return "redirect:/app/index";
        return "forward:/app/index";
    }
}
