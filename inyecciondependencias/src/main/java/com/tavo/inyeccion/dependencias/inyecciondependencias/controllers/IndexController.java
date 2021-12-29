package com.tavo.inyeccion.dependencias.inyecciondependencias.controllers;

import com.tavo.inyeccion.dependencias.inyecciondependencias.models.service.Iservicio;
import com.tavo.inyeccion.dependencias.inyecciondependencias.models.service.MiServicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("miServicioComplejo")
    private Iservicio servicio;

    @GetMapping({"index","","/"})
    public String index(Model model){
        model.addAttribute("objeto", servicio.operacion());
        return "index";
    }
    
}
