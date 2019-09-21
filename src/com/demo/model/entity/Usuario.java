package com.demo.model.entity;

import java.util.UUID;

public class Usuario {

    private UUID id;
    private String email;
    private String contraseña;
    private String nombres;
    private String apellidos;
    private int tipo;

    public Usuario() {
    }

    public Usuario(UUID id, String nombres, String apellidos, String email, String contraseña, int tipo) {
        this.id = id;
        this.email = email;
        this.contraseña = contraseña;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.tipo = tipo;
    }
    
    public Usuario(String email, String clave) {
        this.email = email;
        this.contraseña = clave;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String clave) {
        this.contraseña = clave;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
}
