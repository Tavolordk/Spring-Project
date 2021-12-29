package com.tavo.spring.application.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
@RequestMapping("/params")
public class EjemploParamsController {

    @GetMapping("/")
    public String index(){
        return "params/index";
    }

    @GetMapping("/string")
    public String param(@RequestParam(name = "texto",required = false, defaultValue = "No insertaste nada") String texto,Model model) {
        model.addAttribute("resultado", "El texto enviado es: " + texto);
        return "params/ver";
    }
/**requestparams puede enviar múltiples parámetros pero es más espacio dentro del paréntesis de la función
 * *sin embargo con httpservletrequest es menos espacio dentro del paréntesis de la función.
 */
    @GetMapping("/mix-params")
    public String param(@RequestParam String saludo, @RequestParam Integer numero, Model model){
        model.addAttribute("resultado", "Los valores enviados son: " + saludo + " " +numero);
        return "params/ver";
    }
    
    @GetMapping("/mix-params-request")
    public String param(HttpServletRequest request, Model model){
        String saludo = request.getParameter("saludo");
        Integer numero = null;
        try {
            numero = Integer.parseInt(request.getParameter("numero"));
        } catch (NumberFormatException e) {
            e.printStackTrace(System.out);
        }
        model.addAttribute("resultado", "Los valores enviados son: " + saludo + " " + numero);
        return "params/ver";
    }
}
