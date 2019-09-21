package com.demo.model;

import com.demo.model.entity.Usuario;

public class ModeloUsuario extends Model {
    
    static public boolean logIn(Usuario user){
        boolean band;
        
        band = validarUsuario(user, true);
        
        return band;
    }
    
    static public boolean logUp(Usuario user){
        boolean band;
        band = crearUsuario(user);
        return band;
    }
    
    static public long recuperarClave(Usuario user){
        //code
        // 1 = Cambio correcto
        // 0 = Error al actualizar
        // -1 = Usuario no existe
        long status;
        
        if(validarUsuario(user, false) == false) {
            status = -1;
        } else {
            status = actualizarContraseña(user);
        }
        
        return status;
    }
}