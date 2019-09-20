package com.demo.model;

import com.demo.model.entity.Usuario;

public class ModeloUsuario extends Model {
    
    static public boolean logIn(Usuario user){
        boolean band;
        band = user.getEmail().compareTo("jordan@gmail.com") == 0 && user.getContraseña().compareTo("123456") == 0;
        return band;
    }
    
    static public long logUp(Usuario user){
        long status = 0;
        System.out.println(user);
        return status;
    }
    
    static public long recuperarClave(Usuario user){
        long status = 0;
        System.out.println(user);
        return status;
    }
}