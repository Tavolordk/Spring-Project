package com.tavo.form.formexample.models.domain;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.tavo.form.formexample.validation.IdentificadorRegex;
import com.tavo.form.formexample.validation.Requerido;

public class Usuario {

    @NotNull
    private Date fecha;

    @NotNull
    @Min(10)
    @Max(16)
    private Integer cuenta;

    //@Pattern(regexp = "[0-9]{2}[.][\\d]{3}[.][\\d]{3}[-][A-Z]{1}")
    @IdentificadorRegex
    private String id;

    //@NotEmpty()
    private String nombre;

    //@NotBlank()
    @Requerido
    private String apellido;

    @NotBlank()
    @Size(min = 8)
    private String username;
    
    @NotBlank()
    @Size(min = 8)
    private String password;
    
    @NotBlank()
    @Email()
    private String email;
    
    public Integer getCuenta() {
        return cuenta;
    }
    public void setCuenta(Integer cuenta) {
        this.cuenta = cuenta;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Date getFecha() {
        return fecha;
    }
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
}
