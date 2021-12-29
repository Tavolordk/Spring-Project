package com.tavo.inyeccion.dependencias.inyecciondependencias.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
//@RequestScope Durará lo que dura una petición http
/**SessionScope dura lo mismo que dura una sesión y lo que se cierra esta */

/**Singleton una vez y vivía hasta que la aplicación parara, scope cada que se pide una nueva
 * *solicitud de http
 ApplicationScope se guarda en el contexto del servlet y no de spring*/
public class Factura implements Serializable{

    @Value("${factura.descripcion}")
    private String descripcion;
    
    @Autowired
    private Cliente cliente;

    @Autowired
    @Qualifier("itemsFacturaOficina")
    private List<ItemFactura> items;

    @PostConstruct
    public void inicializar(){
       cliente.setNombre("Octavio");
    }

    @PreDestroy
    public void destruir(){
        System.out.println("Factura destruida ".concat(descripcion));
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ItemFactura> getItems() {
        return items;
    }

    public void setItems(List<ItemFactura> items) {
        this.items = items;
    }

}
