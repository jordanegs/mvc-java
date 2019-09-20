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
    
    public long logUp(String nombres, String apellidos, String email, String contraseña){
        long status = 0;
        
        UUID id = UUID.randomUUID();
        Usuario usuario = new Usuario(id, email, contraseña, nombres, apellidos, 1);
        ModeloUsuario.logUp(usuario);
        
        return status;
    }

    public long recuperarClave(String email, String contraseña) {
        long status = 0;
        
        Usuario user = new Usuario(email, contraseña);
        ModeloUsuario.recuperarClave(user);
        
        return status;
    }
}
