package com.tavo.inyeccion.dependencias.inyecciondependencias.models.service;

import org.springframework.stereotype.Component;

//@Component("miServicioSimple")
public class MiServicio implements Iservicio{

    @Override
    public String operacion(){
        return "ejecutando algún proceso simple";
   }
    
}
