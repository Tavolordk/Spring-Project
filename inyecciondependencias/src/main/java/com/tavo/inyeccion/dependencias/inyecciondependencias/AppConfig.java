package com.tavo.inyeccion.dependencias.inyecciondependencias;

import java.util.Arrays;
import java.util.List;

import com.tavo.inyeccion.dependencias.inyecciondependencias.models.domain.ItemFactura;
import com.tavo.inyeccion.dependencias.inyecciondependencias.models.domain.Producto;
import com.tavo.inyeccion.dependencias.inyecciondependencias.models.service.Iservicio;
import com.tavo.inyeccion.dependencias.inyecciondependencias.models.service.MiServicio;
import com.tavo.inyeccion.dependencias.inyecciondependencias.models.service.MiServicioComplejo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class AppConfig {

    @Bean("miServicioSimple")
    @Primary
    public Iservicio registrarMiIservicio(){
        return new MiServicio();
    }

    @Bean("miServicioComplejo")
    public Iservicio registrarMiIservicioComplejo(){
        return new MiServicioComplejo();
    }

    @Bean("itemsFactura")
    public List<ItemFactura> registrarItems(){
        Producto p1 = new Producto("Chocokrispis", 45);
        Producto p2 = new Producto("Zucaritas", 28);

        ItemFactura l1 = new ItemFactura(p1, 500);
        ItemFactura l2 = new ItemFactura(p2, 1000);

        return Arrays.asList(l1,l2);
    }

    @Bean("itemsFacturaOficina")
    public List<ItemFactura> registrarItemsOficina(){
        Producto p1 = new Producto("Lapiceros", 250);
        Producto p2 = new Producto("Borradores", 500);
        Producto p3 = new Producto("Reglas", 34);
        Producto p4 = new Producto("Resistol", 20);

        ItemFactura l1 = new ItemFactura(p1, 500);
        ItemFactura l2 = new ItemFactura(p2, 1000);
        ItemFactura l3 = new ItemFactura(p3, 348);
        ItemFactura l4 = new ItemFactura(p4, 380);

        return Arrays.asList(l1,l2, l3,l4);
    }
}
