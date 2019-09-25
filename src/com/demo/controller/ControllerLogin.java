package com.demo.controller;

import com.demo.model.ModeloUsuario;
import com.demo.model.entity.Usuario;
import java.util.UUID;

public class ControllerLogin extends Controller{
    
    public ControllerLogin() {}
    
    public boolean logIn(String usuario, String contraseña){
        boolean band;
        
        Usuario user = new Usuario(usuario, contraseña);
        band = ModeloUsuario.logIn(user);
        
        return band;
    }
    
    public boolean logUp(String nombres, String apellidos, String email, String contraseña){
        boolean band;
        
        UUID id = UUID.randomUUID();
        Usuario usuario = new Usuario(id, nombres, apellidos, email, contraseña, 1);
        band = ModeloUsuario.logUp(usuario);
        
        return band;
    }

    public long recuperarClave(String email, String contraseña) {
        long status;
        
        Usuario usuario = new Usuario(email, contraseña);
        status = ModeloUsuario.recuperarClave(usuario);
        
        return status;
    }
}
