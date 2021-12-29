package com.tavo.inyeccion.dependencias.inyecciondependencias.models.service;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

//@Component("miServicioComplejo")
//@Primary
public class MiServicioComplejo implements Iservicio{

    @Override
    public String operacion(){
        return "ejecutando algún proceso complejo";
   }
    
}
