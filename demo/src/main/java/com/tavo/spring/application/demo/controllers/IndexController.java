package com.tavo.spring.application.demo.controllers;

import java.util.Arrays;
import java.util.List;

import com.tavo.spring.application.demo.models.Usuario;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/app")
public class IndexController {

    @Value("${texto.indexcontroller.index.titulo}")
    private String textoIndex;

    @Value("${texto.indexcontroller.perfil.titulo}")
    private String textoPerfil;

    @Value("${texto.indexcontroller.listar.titulo}")
    private String textoListar;

    @GetMapping({"/","/index","/home"})
    public String indexModel(Model model){
        model.addAttribute("titulo", textoIndex);
        return "index";
    }

    @RequestMapping("/perfil")
    public String perfil(Model model){
        Usuario usuario = new Usuario();
        usuario.setNombre("Octavio");
        usuario.setApellido("Olea Pérez");
        usuario.setEmail("tavo.0540@gmail.com");
        model.addAttribute("titulo", textoPerfil);
        model.addAttribute("usuario", usuario);
        return "perfil";
    }

    @RequestMapping("/listar")
    public String listar(Model model){  
        /*
        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario("Patricio","Estrella","patricio@gmail.com"));
        usuarios.add(new Usuario("Arenita","Mejilla","arenita@outlook.com"));
        usuarios.add(new Usuario("Calamardo","Tentáculos","amargado@hotmail.com"));
        Este es una forma de implementar el agregar a un array
        */
        model.addAttribute("titulo", textoListar);
        return "listar";
    }

    /**ModelAttribute pasa todos los datos del model a todas las vistas del controlador
     **todos pueden consultar los datos si están dentro del mismo controlador donde 
     **se declara.
     */
    @ModelAttribute("usuarios")
    public List<Usuario> poblarUsuarios(){
          //Esta es otra manera de implementar el Array
          List<Usuario> usuarios = Arrays.asList(new Usuario("Patricio","Estrella","patricio@gmail.com"),
          new Usuario("Arenita","Mejilla","arenita@outlook.com"),
          new Usuario("Calamardo","Tentáculos","amargado@hotmail.com"),
          new Usuario("Don Cangrejo","Tacañin el tacaño","dinero@dinero.com"));
          return usuarios;
    }
}
